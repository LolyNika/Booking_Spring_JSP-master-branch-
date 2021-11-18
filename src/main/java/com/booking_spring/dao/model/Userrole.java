package com.booking_spring.dao.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter

@Entity
@Table(name = "userrole")
public class Userrole implements Serializable {
    @Id
    @Column(name = "roleId")
    private int roleId;

    @Column(name = "name")
    private String name;
}
