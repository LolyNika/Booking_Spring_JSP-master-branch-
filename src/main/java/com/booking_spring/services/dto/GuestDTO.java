package com.booking_spring.services.dto;

import com.booking_spring.dao.model.Booking;
import lombok.*;

import java.util.Set;
/**
 * Class with Guest variables (idGuest; nameGuest; mobile; email; address; user; UserRole_guests; bookings)
 * The class is used for DTO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class GuestDTO {
    private int idGuest;
    private String nameGuest;
    private int mobile;
    private String email;
    private String address;
    private UserDTO user;
    private UserroleDTO UserRole_guests;
    private Set<Booking> bookings;
}
