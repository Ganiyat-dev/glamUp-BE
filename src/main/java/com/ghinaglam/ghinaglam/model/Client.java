package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends BaseEntity {
    private String firstName;
    private String lastName;
    //    @Column(name = "email", unique = true)
    private String email;
    private String gender;
    //    @Column(unique = true)
    private String phoneNumber;
    private String password;
    private String address;

    private Category category = Category.CLIENT;

    @Transient
    private String streetAddress;
    @Transient
    private String city;
    @Transient
    private String state;

//    @OneToMany(mappedBy = "client")
//    private List<AppointmentAssigned> appointmentAssigned;
}
