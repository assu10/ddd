package com.assu.study.lock;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SpringLockManager implements LockManager {
    private final JdbcTemplate jdbcTemplate;
    // 잠금 유효 시간은 5분
    private int LOCK_TIMEOUT = 5 * 60 * 1000;

    // locks 테이블에서 조회한 데이터를 LockData 로 매핑하기 위한 RowMapper
    private RowMapper<LockData> lockDataRowMapper = (rs, rowNum) ->
            new LockData(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getTimestamp(4).getTime());

    // type, id 에 대한 잠금 시도
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public LockId tryLock(String type, String id) throws LockException {
        // 해당 type, id 에 대한 잠금이 존재하는지 확인
        checkAlreadyLocked(type, id);

        // 새로운 lockId 생성
        // 매번 새로운 lockId 를 생성해야 하므로 UUID 이용
        LockId lockId = new LockId(UUID.randomUUID().toString());

        // 잠금 생성
        locking(type, id, lockId);

        // lockId 리턴
        return lockId;
    }

    // 해당 type, id 에 대한 잠금이 존재하는지 확인
    private void checkAlreadyLocked(String type, String id) {
        List<LockData> locks = jdbcTemplate.query(
                "select * from locks where type = ? and id = ?",
                lockDataRowMapper, type, id);

        // 유효 시간이 지난 데이터 처리
        Optional<LockData> oLockData = handelExpiration(locks);

        // 유효 시간이 지나지 않은 LockData 가 존재하면 예외 발생
        if (oLockData.isPresent()) {
            throw new AlreadyLockedException();
        }
    }

    // 잠금 유효 시간이 지나면 해당 데이터를 삭제 후 빈 Optional 리턴
    // 유효 시간이 지나지 않았으면 해당 LockData 를 가진 Optional 리턴
    private Optional<LockData> handelExpiration(List<LockData> locks) {
        if (locks.isEmpty()) {
            return Optional.empty();
        }

        LockData lockData = locks.get(0);

        if (lockData.isExpired()) {
            jdbcTemplate.update(
                    "delete from locks where type = ? and id = ?",
                    lockData.getType(), lockData.getId());
            return Optional.empty();
        } else {
            return Optional.of(lockData);
        }
    }

    // 잠금을 위해 locks 테이블에 데이터 삽입
    // 삽입된 데이터가 없으면 예외 발생
    // 동일한 PK 나 lockId 를 가진 데이터가 이미 존재하여 DuplicateKeyException 이 발생하면 예외 발생
    private void locking(String type, String id, LockId lockId) {
        try {
            int updatedCount = jdbcTemplate.update(
                    "insert into locks value (?, ?, ?, ?)",
                    type, id, lockId.getValue(), new Timestamp(getExpirationTime()));
            if (updatedCount == 0) {
                throw new LockingFailException();
            }
        } catch (DuplicateKeyException e) {
            throw new LockingFailException(e);
        }
    }

    // 현재 시간 기준으로 잠금 유효 시간(5분) 이후 시간을 유효 시간으로 생성
    private long getExpirationTime() {
        return System.currentTimeMillis() + LOCK_TIMEOUT;
    }

    // 잠금이 유효한지 확인한 후 유효하지 않으면 예외 발생
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void checkLock(LockId lockId) throws LockException {
        Optional<LockData> lockData = getLockData(lockId);
        if (!lockData.isPresent()) {
            throw new NoLockException();
        }
    }

    // lockId 에 해당하는 LockData 를 구한 후 유효 시간이 지난 LockData 처리
    private Optional<LockData> getLockData(LockId lockId) {
        List<LockData> locks = jdbcTemplate.query(
                "select * from locks where lockid = ?",
                lockDataRowMapper, lockId.getValue());
        return handelExpiration(locks);
    }

    // lockId 에 해당하는 잠금 유효 시간은 inc 만큼 증가시킴
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void extendLockExpiration(LockId lockId, long inc) throws LockException {
        Optional<LockData> oLockData = getLockData(lockId);
        LockData lockData = oLockData.orElseThrow(() -> new NoLockException());
        jdbcTemplate.update(
                "update locks set expiration_time = ? where type = ? and id = ?",
                new Timestamp(lockData.getTimestamp() + inc),
                lockData.getType(), lockData.getId());
    }

    // lockId 에 해당하는 잠금 데이터 삭제
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void releaseLock(LockId lockId) throws LockException {
        jdbcTemplate.update("delete from locks where lockid = ?", lockId.getValue());
    }
}
