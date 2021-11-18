package com.booking_spring.services.dto;

import lombok.*;

/**
 * Class with Booking variables (idBooking; checkInDate; checkOutDate; adultscount; childrencount; roomtype; comment; bookingstatus; paymethod; guest; room; rate; roomstatus)
 * The class is used for DTO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class BookingDTO {
    private int idBooking;

    private String checkInDate;

    private String checkOutDate;

    private int adultsCount;

    private int childrenCount;

    private String roomType;

    private String comment;

    private String bookingStatus;

    private PaymethodDTO  paymethod;

    private GuestDTO guest;

    private RoomDTO room;

    private RateDTO rate;

    private RoomstatusDTO roomstatus;
}
