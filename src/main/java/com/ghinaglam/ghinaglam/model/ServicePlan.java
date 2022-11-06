package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ServicePlan extends BaseEntity {
    private String serviceName;
    private String serviceDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Plan> plan = new ArrayList<>();

}
