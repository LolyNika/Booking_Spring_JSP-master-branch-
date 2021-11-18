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
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "userId")
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
}
