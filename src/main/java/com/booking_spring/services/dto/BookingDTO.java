package com.booking_spring.services.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class BookingDTO {
    private int bookingId;
    private int checkindate;
    private int checkoutdate;
    private int adultscount;
    private int childrencount;
    private String roomtype;
    private String comment;
    private String bookingstatus;
}
