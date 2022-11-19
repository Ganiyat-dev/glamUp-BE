package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentAssigned extends BaseEntity {
    @OneToOne
    private Appointment appointment;

    @ManyToOne
    private MakeupArtist makeupArtist;

    @ManyToOne
    private Client client;
//    TODO: How to map makeupArtists

    private Time appointmentStartTime;
    private Time appointmentEndTime;
    private Status status = Status.STARTED;
    private LocalDate dateCompleted;

    // appointment_id, makeup_id, status, dateCompleted,
}
