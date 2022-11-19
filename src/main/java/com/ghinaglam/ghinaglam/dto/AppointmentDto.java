package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.Client;
import com.ghinaglam.ghinaglam.model.Plan;
import com.ghinaglam.ghinaglam.model.Status;
import lombok.Data;
import java.sql.Time;
import java.time.LocalDate;

@Data
public class AppointmentDto {
    private Integer id;
    private Client client;
    private Plan plan;
    private LocalDate startDate;
    private Status status = Status.PENDING;
    private Boolean isAssigned = false;
}
