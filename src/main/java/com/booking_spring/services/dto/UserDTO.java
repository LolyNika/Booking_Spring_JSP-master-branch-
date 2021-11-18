package com.booking_spring.services.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class UserDTO {
    private int userId;
    private String name;
    private String password;
}
