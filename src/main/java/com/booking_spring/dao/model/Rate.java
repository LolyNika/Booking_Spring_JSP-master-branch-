package com.booking_spring.dao.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter

@Entity
@Table(name = "rate")
public class Rate implements Serializable {
    @Id
    @Column(name = "rateId")
    private int rateId;

    @Column(name = "date")
    private int date;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;
}
