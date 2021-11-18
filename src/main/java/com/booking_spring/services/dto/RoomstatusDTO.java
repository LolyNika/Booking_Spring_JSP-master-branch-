package com.booking_spring.services.dto;

import lombok.*;
/**
 * Class with Roomstatus variables (roomstatusId; nameStatus; rooms)
 * The class is used for DTO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class RoomstatusDTO {
    private int roomstatusId;
    private String nameStatus;
}
