package com.ghinaglam.ghinaglam.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class ServicePlan extends BaseEntity {
    private String serviceName;
    private String serviceDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Plan> plan = new ArrayList<>();

}
