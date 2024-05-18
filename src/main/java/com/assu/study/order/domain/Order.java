package com.assu.study.order.domain;

import java.util.List;

// 주문
public class Order {
    // OrderNo 타입 자체로 id 가 주문 번호임을 알 수 있음
    private OrderNo id;
    private Orderer orderer;

    private OrderState state;
    private List<OrderLine> orderLines;
    private ShippingInfo shippingInfo;
    //private Money totalAmounts;

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
//        this.totalAmounts = orderLines.stream()
//                .mapToInt(x -> x.getAmounts().getValue())
//                .sum();
    }

    // 배송지 정보 검사 후 배송지 값 설정
    private void setShippingInfo(ShippingInfo shippingInfo) {
        // 배송지 정보는 필수임
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no shippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }

    // 배송지 변경
    public void changeShippingInfo(ShippingInfo newShipping) {
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