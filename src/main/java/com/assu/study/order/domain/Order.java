package com.assu.study.order.domain;

import java.util.List;

// 주문
public class Order {
    private String orderNumber;
    private OrderState state;
    private List<OrderLine> orderLines;
    private ShippingInfo shippingInfo;
    //private Money totalAmounts;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    // 생성자에서 호출되는 함수
    // 요구사항에서 정의한 제약 조건 검사
    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrderLine(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
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
                .mapToInt(OrderLine::getAmounts)
                .sum();
        //this.totalAmounts = new Money(sum);
    }

    // 배송지 정보 검사
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

    public void completePayment() {
        // TODO
    }
}