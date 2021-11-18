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
@Table(name = "roomstatus")
public class Roomstatus implements Serializable {
    @Id
    @Column(name = "roomstatusId")
    private int roomstatusId;

    @Column(name = "name")
    private String name;
}
