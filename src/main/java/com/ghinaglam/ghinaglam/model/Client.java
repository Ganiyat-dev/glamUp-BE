package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Client extends BaseEntity{
    private int age;
    private Enum gender;

    @OneToOne
    private User user;
}
