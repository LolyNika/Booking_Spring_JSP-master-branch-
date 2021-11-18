package com.booking_spring.dao.model;
import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.Set;
/**
 * Class with Roomstatus variables (roomstatusId; nameStatus; rooms)
 * The class is used for DAO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "roomstatus")
public class Roomstatus implements Serializable {
    @Id
    @Column(name = "idroomStatus")
    private int roomstatusId;

    @Column(name = "nameStatus")
    private String nameStatus;

    @OneToMany(mappedBy="roomstatus")
    private Set<Room> rooms;
}
