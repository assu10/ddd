package com.assu.study.order.command.domain;

// 주문 상태 표현
public enum OrderState {
    PAYMENT_WAITING,    // 결제 대기중
    PREPARING,  // 상품 준비중
    SHIPPED,    // 출고 완료
    DELIVERING, // 배송 중
    DELIVERY_COMPLETED, // 배송 완료
    CANCELED;   // 주문 취소
}
