package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment extends BaseEntity {
    private LocalDate startDate;
    private Status status = Status.PENDING;
    private Boolean isAssigned = false;


    @ManyToOne
    private Plan plan;
    @ManyToOne
    private Client client;

}
