package com.booking_spring.services.dto;

import com.booking_spring.dao.model.Userrole;
import lombok.*;
/**
 * Class with User variables (userId; nameUser; password; userRole; guest)
 * The class is used for DTO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class UserDTO {
    private int userId;
    private String nameUser;
    private String password;
    private Userrole userRole;
}
