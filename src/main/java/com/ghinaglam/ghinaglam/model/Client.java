package com.ghinaglam.ghinaglam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client extends BaseEntity{
    private int age;
    private Enum gender;

    @OneToOne
    private User user;
}
