package com.booking_spring.services.dto;

import lombok.*;
/**
 * Class with Paymethod variables (paymethodId; name; cardholderName; expirationDate; cardNumber; cvsCode; transactionId; transactionDate; transactionStatus; sum)
 * The class is used for DTO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class PaymethodDTO {
    private int paymethodId;
    private String name;
    private String cardholderName;
    private int expirationDate;
    private int cardNumber;
    private int cvsCode;
    private int transactionId;
    private int transactionDate;
    private String transactionStatus;
    private int sum;
}
