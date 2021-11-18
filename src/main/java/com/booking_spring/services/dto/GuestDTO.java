package com.booking_spring.services.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class GuestDTO {
    private int guestId;
    private String name;
    private int mobile;
    private String email;
    private String address;
}
