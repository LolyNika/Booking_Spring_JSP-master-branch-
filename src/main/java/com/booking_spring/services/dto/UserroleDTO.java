package com.booking_spring.services.dto;

import com.booking_spring.dao.model.User;
import lombok.*;

import java.util.Set;
/**
 * Class with Userrole variables (roleId; nameRole; users; guests)
 * The class is used for DTO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class UserroleDTO {
    private int roleId;
    private String nameRole;
    private Set<User> users;
}
