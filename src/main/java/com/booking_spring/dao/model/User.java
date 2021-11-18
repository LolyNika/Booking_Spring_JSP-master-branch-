package com.booking_spring.dao.model;
import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
/**
 * Class with User variables (userId; nameUser; password; userRole; guest)
 * The class is used for DAO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "userId")
    private int userId;

    @Column(name = "nameUser")
    private String nameUser;

    @Column(name = "password")
    private String password;

//    @Column(name = "roleId")
//    private int roleId;

    @ManyToOne
    @JoinColumn
    private Userrole userRole;

    @OneToOne(mappedBy = "user")
    private Guest guest;
}
