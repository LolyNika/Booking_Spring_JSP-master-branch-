package com.booking_spring.dao.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
/**
 * Class with Userrole variables (roleId; nameRole; users; guests)
 * The class is used for DAO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "userrole")
public class Userrole implements Serializable {
    @Id
    @Column(name = "roleId")
    private int roleId;

    @Column(name = "nameRole")
    private String nameRole;

    @OneToMany(mappedBy="userRole")
    private Set<User> users;

    @OneToMany(mappedBy="UserRole_guests")
    private Set<Guest> guests;
}
