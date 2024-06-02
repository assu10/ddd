package com.assu.study.order.command.domain;

import com.assu.study.member.command.domain.MemberId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode  // 밸류 타입
@Embeddable
public class Orderer {
    // MemberId 에 정의된 멤버 변수 id 를 orderer_id 컬럼명으로 변경
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;
}
