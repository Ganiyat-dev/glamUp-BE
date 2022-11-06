package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakeUpDto extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    //    @Column(unique = true)
    private String phoneNumber;
    private String password;
    private String license;
    private int yearsOfExperience;
    private double salary;
}
