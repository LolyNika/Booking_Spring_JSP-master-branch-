package com.booking_spring.dao.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

import java.io.Serializable;
/**
 * Class with Paymethod variables (paymethodId; name; cardholderName; expirationDate; cardNumber; cvsCode; transactionId; transactionDate; transactionStatus; sum)
 * The class is used for DAO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "paymethod")
public class Paymethod implements Serializable {
    @Id
    @Column(name = "paymethodId")
    private int paymethodId;

    @Column(name = "name")
    private String name;

    @Column(name = "cardholderName")
    private String cardholderName;

    @Column(name = "expirationDate")
    private int expirationDate;

    @Column(name = "cardNumber")
    private int cardNumber;

    @Column(name = "cvsCode")
    private int cvsCode;

    @Column(name = "transactionId")
    private int transactionId;

    @Column(name = "transactionDate")
    private String transactionDate;

    @Column(name = "transactionStatus")
    private String transactionStatus;

    @Column(name = "sum")
    private int sum;
}
