package com.booking_spring.services.dto;

import lombok.*;
/**
 * Class with Room variables (idRoom; nameRoom; roomstatus; rate; bookings)
 * The class is used for DTO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class RoomDTO {
    private int idRoom;
    private String nameRoom;
    private RoomstatusDTO roomstatus;
    private RateDTO rate;
}
