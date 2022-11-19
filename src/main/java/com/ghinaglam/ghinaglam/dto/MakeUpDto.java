package com.ghinaglam.ghinaglam.dto;
import com.ghinaglam.ghinaglam.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class MakeUpDto{
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    //    @Column(unique = true)
    private String phoneNumber;
    private String password;
    private String license;
    private int yearsOfExperience;
    private double salary;
    private Category category;
}
