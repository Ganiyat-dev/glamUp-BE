package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity{
    private int houseNumber;
    private String street;
    private String city;
    private String state;

    @OneToMany(mappedBy = "address")
    private Set<User> users;
}
