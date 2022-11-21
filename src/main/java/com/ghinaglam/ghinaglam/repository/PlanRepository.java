package com.ghinaglam.ghinaglam.repository;

import com.ghinaglam.ghinaglam.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    boolean existsByPlanName(String planName);
}
