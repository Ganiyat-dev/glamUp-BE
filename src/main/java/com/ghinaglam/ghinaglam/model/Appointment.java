package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment extends BaseEntity{
    private String name;
    private String phoneNumber;
    private LocalDate startDate;
    private Status status = Status.PENDING;
    private Boolean isAssigned = false;

    @ManyToOne
    private Plan plan;

    @ManyToOne
    private Client client;

    @ManyToOne
    private MakeupArtist makeupArtist;

//    @OneToOne
//    @JoinColumn(name = "address_id")
//    private Address address;


}
