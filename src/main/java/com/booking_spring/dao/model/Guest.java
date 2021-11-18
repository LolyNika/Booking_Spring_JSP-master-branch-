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
@Table(name = "guest")
public class Guest implements Serializable {
    @Id
    @Column(name = "guestId")
    private int guestId;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private int mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;
}
