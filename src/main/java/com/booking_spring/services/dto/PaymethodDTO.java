package com.booking_spring.services.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class PaymethodDTO {
    private int paymethodId;
    private String name;
    private String cardholdername;
    private int expirationdate;
    private int cardnumber;
    private int cvscode;
    private int transactionId;
    private int transactionDate;
    private String transactionStatus;
    private int sum;
}
