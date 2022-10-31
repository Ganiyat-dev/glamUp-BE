package com.ghinaglam.ghinaglam.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
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
