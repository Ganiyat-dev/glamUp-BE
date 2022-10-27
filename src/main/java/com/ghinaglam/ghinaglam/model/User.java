package com.ghinaglam.ghinaglam.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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

    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

}
