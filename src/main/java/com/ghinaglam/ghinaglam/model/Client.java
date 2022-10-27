package com.ghinaglam.ghinaglam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Enum gender;

    @OneToOne(mappedBy = "client")
    private Address address;

}
