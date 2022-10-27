package com.ghinaglam.ghinaglam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address extends BaseEntity{
    private int houseNumber;
    private String street;
    private String city;
    private String state;
}
