package com.ghinaglam.ghinaglam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ServicePlan extends BaseEntity {
    private String serviceName;
    private String serviceDetails;

    @JsonIgnore
    @ManyToMany
    private List<Plan> plan = new ArrayList<>();

}
