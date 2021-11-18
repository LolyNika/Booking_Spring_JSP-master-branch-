package com.booking_spring.dao.model;
import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.Set;
/**
 * Class with Rate variables (rateId; date; price; rooms)
 * The class is used for DAO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "rate")
public class Rate implements Serializable {

    @Id
    @Column(name = "idrate")
    private int rateId;

    @Column(name = "date")
    private int date;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy="rate")
    private Set<Room> rooms;
}
