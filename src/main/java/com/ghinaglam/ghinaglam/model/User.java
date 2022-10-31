package com.ghinaglam.ghinaglam.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity

public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private String password;

    @OneToMany
    private List<Address> address;

//    todo: research if user to appointment is many to many relationship
    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

}
