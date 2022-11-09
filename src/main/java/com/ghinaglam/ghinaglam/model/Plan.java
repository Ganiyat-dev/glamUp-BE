package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plans")
public class Plan extends BaseEntity {
    private String planName;
    private String planDescription;
    private int planPrice;
    private String planSession;

    @ManyToMany(mappedBy = "plan")
    private List<ServicePlan> servicePlans = new ArrayList<>();

    @OneToMany
    private List<Appointment> appointment;


}
