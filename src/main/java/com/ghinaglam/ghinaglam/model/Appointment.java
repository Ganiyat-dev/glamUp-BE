package com.ghinaglam.ghinaglam.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Entity
public class Appointment extends BaseEntity{
    @ManyToOne
    private Plan plan;

    @ManyToOne
    private User user;

    private LocalDate startDate;
    private Status status = Status.PENDING;
    private Boolean isAssigned = false;

}
