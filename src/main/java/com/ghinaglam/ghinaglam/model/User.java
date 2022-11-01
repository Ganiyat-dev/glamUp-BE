package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Address> address = new HashSet<>();

//    todo: research if user to appointment is many to many relationship
    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

}
