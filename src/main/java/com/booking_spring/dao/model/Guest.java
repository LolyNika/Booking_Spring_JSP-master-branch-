package com.booking_spring.dao.model;
import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.Set;
/**
 * Class with Guest variables (idGuest; nameGuest; mobile; email; address; user; UserRole_guests; bookings)
 * The class is used for DAO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "guest")
public class Guest implements Serializable {
    @Id
    @Column(name = "idguest")
    private int idGuest;

    @Column(name = "nameGuest")
    private String nameGuest;

    @Column(name = "mobile")
    private int mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn (name="userId")
    private User user;

    @ManyToOne
    @JoinColumn (name="roleId")
    private Userrole UserRole_guests;

    @OneToMany (mappedBy = "guest")
    private Set<Booking> bookings;

}
