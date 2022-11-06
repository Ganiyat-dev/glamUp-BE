package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class ClientDto extends BaseEntity {
    private String firstName;
    private String lastName;
    @Email
    private String email;

    private String phoneNumber;
    private String password;
    private int age;

}
