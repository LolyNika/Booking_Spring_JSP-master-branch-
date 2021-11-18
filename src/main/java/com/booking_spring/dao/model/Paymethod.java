package com.booking_spring.dao.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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
    private String cardholdername;

    @Column(name = "expirationDate")
    private int expirationdate;

    @Column(name = "cardNumber")
    private int cardnumber;

    @Column(name = "cvsCode")
    private int cvscode;

    @Column(name = "transactionId")
    private int transactionId;

    @Column(name = "transactionDate")
    private int transactionDate;

    @Column(name = "transactionStatus")
    private String transactionStatus;

    @Column(name = "sum")
    private int sum;
}
