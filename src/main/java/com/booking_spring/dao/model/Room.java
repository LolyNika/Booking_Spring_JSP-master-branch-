package com.booking_spring.dao.model;
import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.Set;
/**
 * Class with Room variables (idRoom; nameRoom; roomstatus; rate; bookings)
 * The class is used for DAO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "room")
public class Room implements Serializable {
    @Id
    @Column(name = "idroom")
    private int idRoom;

    @Column(name = "name")
    private String nameRoom;

    @ManyToOne
    @JoinColumn (name="idroomStatus")
    private Roomstatus roomstatus;

    @ManyToOne
    @JoinColumn (name="idrate")
    private Rate rate;

    @OneToMany (mappedBy = "room")
    private Set<Booking> bookings;
}
