package com.assu.study.order.command.domain;

import com.assu.study.common.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

// 주문 (애그리거트 루트)
@Entity
@Table(name = "TBL_ORDER")
public class Order {
    // OrderNo 타입 자체로 id 가 주문 번호임을 알 수 있음
    private OrderNo id;
    private Orderer orderer;    // 주문자

    private OrderState state;   // 주문 상태
    private List<OrderLine> orderLines; // 주문 항목
    private ShippingInfo shippingInfo;  // 배송지 정보
    private Money totalAmounts;   // 총 주문 금액

    // 생성자 호출 시점에 필요한 데이터에 대한 검증 확인 가능
    public Order(Orderer orderer, List<OrderLine> orderLines, ShippingInfo shippingInfo, OrderState state) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
    }

    // 생성자에서 호출되는 함수
    // 요구사항에서 정의한 제약 조건 검사
    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrderLine(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) {
            throw new IllegalArgumentException("no orderer");
        }
        this.orderer = orderer;
    }

    // 최소 한 종류 이상의 상품이 포함되어 있는지 확인
    private void verifyAtLeastOneOrderLine(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no orderLine");
        }
    }

    // 총 주문 금액 계산
    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .mapToInt(x -> x.getAmounts().getValue())
                .sum();
        this.totalAmounts = new Money(sum);
    }

    // 배송지 정보 검사 후 배송지 값 설정
    private void setShippingInfo(ShippingInfo newShippingInfo) {
        // 배송지 정보는 필수임
        if (newShippingInfo == null) {
            throw new IllegalArgumentException("no shippingInfo");
        }
        // 밸류가 불변이면 새로운 객체를 할당해서 값을 변경해야 함
        // 즉, 아래와 같은 코드는 사용 불가
        // this.shippingInfo.setAddress(newShippingInfo.getAddress())

        // 밸류 타입의 데이터를 변경할 때는 새로운 객체로 교체함
        this.shippingInfo = newShippingInfo;
    }

    // 애그리거트 루트는 도메인 규칙을 구현한 기능을 제공함
    // 도메인 모델의 엔티티는 도메인 기능도 함께 제공
    // 배송지 변경
    public void changeShippingInfo(ShippingInfo newShipping) {
        // 배송지 변경 가능 여부 확인
        verifyNotYetShipped();
        setShippingInfo(newShipping);
    }

    // 주문 취소
    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    // 출고 전 상태인지 검사
    private void verifyNotYetShipped() {
        // 결제 전 이 아니고, 상품 준비중이 아니면 이미 출고된 상태임
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalArgumentException("already shipped");
        }
    }

    public void changeShipped() {
        // TODO
    }

    // 결제 완료 확인
    public void completePayment() {
        // TODO
    }
}