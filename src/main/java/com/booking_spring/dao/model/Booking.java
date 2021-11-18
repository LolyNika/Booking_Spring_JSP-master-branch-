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
@Table (name = "booking")
public class Booking implements Serializable {
    @Id
    @Column(name = "bookingId")
    private int bookingId;

    @Column(name = "checkindate")
    private int checkindate;

    @Column(name = "checkoutdate")
    private int checkoutdate;

    @Column(name = "adultscount")
    private int adultscount;

    @Column(name = "childrencount")
    private int childrencount;

    @Column(name = "roomtype")
    private String roomtype;

    @Column(name = "comment")
    private String comment;

    @Column(name = "bookingstatus")
    private String bookingstatus;
}
