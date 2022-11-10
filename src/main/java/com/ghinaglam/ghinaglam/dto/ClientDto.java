package com.ghinaglam.ghinaglam.dto;
import com.ghinaglam.ghinaglam.model.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    //    @Column(name = "email", unique = true)
    private String email;
    //    @Column(unique = true)
    private String phoneNumber;
    private String password;
    private int age;

    private String address;
    private Category category;

}
