package com.booking_spring.dao.model;
import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
/**
 * Class with Booking variables (idBooking; checkInDate; checkOutDate; adultscount; childrencount; roomtype; comment; bookingstatus; paymethod; guest; room; rate; roomstatus)
 * The class is used for DAO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table (name = "booking")
public class Booking implements Serializable {
    @Id
    @Column(name = "idbooking")
    private int idBooking;

    @Column(name = "checkindate")
    private String checkInDate;

    @Column(name = "checkoutdate")
    private String checkOutDate;

    @Column(name = "adultscount")
    private int adultsCount;

    @Column(name = "childrencount")
    private int childrenCount;

    @Column(name = "roomtype")
    private String roomType;

    @Column(name = "comment")
    private String comment;

    @Column(name = "bookingstatus")
    private String bookingStatus;

    @ManyToOne
    @JoinColumn (name="paymethodId")
    private Paymethod paymethod;

    @ManyToOne
    @JoinColumn (name="idguest")
    private Guest guest;

    @ManyToOne
    @JoinColumn (name="room_idroom")
    private Room room;

    @ManyToOne
    @JoinColumn (name="room_idroomStatus")
    private Roomstatus roomStatus;

    @ManyToOne
    @JoinColumn (name="room_idrate")
    private Rate rate;
}
