package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.PlanDto;
import com.ghinaglam.ghinaglam.model.Plan;
import com.ghinaglam.ghinaglam.model.ServicePlan;
import com.ghinaglam.ghinaglam.repository.PlanRepository;
import com.ghinaglam.ghinaglam.repository.ServicePlanRepository;
import com.ghinaglam.ghinaglam.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

    private final ServicePlanRepository servicePlanRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<Plan> getPlans() {
        return planRepository.findAll();
    }

    @Override
    public PlanDto getPlan(Long id) {
        if (planRepository.existsById(id)) {
            return mapToDto(planRepository.findById(id).orElseThrow(()-> new IllegalStateException("No Plan found")));
        }
        throw new IllegalStateException("Plan not found");
    }

    @Override
    public PlanDto savePlan(PlanDto planDto, List<Long> servicesId) {

        if (servicesId != null) {
            Set<ServicePlan> servicePlanSet = new HashSet<>();
            for (long serviceId: servicesId) {
                log.info("The service plan is {}", serviceId);
                ServicePlan servicePlan = servicePlanRepository.findById(serviceId).orElseThrow(()-> new IllegalStateException("No service found"));
                servicePlanSet.add(servicePlan);
            }
            planDto.setServicePlans(servicePlanSet);
        }
        Plan plan = mapToEntity(planDto);
        if (planRepository.existsByPlanName(plan.getPlanName())) {
            throw new IllegalStateException("Plan Already Exists");
        }
        return mapToDto(planRepository.save(plan));
    }
    //    @Override
//    public PlanDto savePlan(PlanDto planDto) {
//        Plan plan =mapToEntity(planDto);
//        if (servicePlanRepository.existsById(planDto.getId())) {
//            throw new IllegalStateException("Service already Exists");
//        }
//        return mapToDto(planRepository.save(plan));
//    }
    @Transactional
    public PlanDto updatePlan(Long id, PlanDto planDto) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Plan with the" + id + " does not exist"));
        plan.setPlanName(planDto.getPlanName());
        plan.setPlanDescription(planDto.getPlanDescription());
        plan.setPlanPrice(planDto.getPlanPrice());
        plan.setPlanSession(planDto.getPlanSession());

        return mapToDto(planRepository.save(plan));
    }

    @Override
    public void addServiceToPlan(long serviceId, long planId) {
        log.info("Adding service to Plan");
        ServicePlan servicePlan = servicePlanRepository.findById(serviceId).orElseThrow(()-> new IllegalStateException("No service found"));
        Plan plan = planRepository.findById(planId).orElseThrow(()-> new IllegalStateException("No Plan found"));
        plan.getServicePlans().add(servicePlan);
    }

    @Override
    public String deletePlan(Long id) {
        if (planRepository.existsById(id)) {
            planRepository.deleteById(id);
            return "Plan deleted!";
        }
        throw new IllegalStateException("Plan not found!");
    }

    private PlanDto mapToDto(Plan plan) {
        return mapper.map(plan, PlanDto.class);
    }

    private Plan mapToEntity(PlanDto planDto) {
        return mapper.map(planDto, Plan.class);
    }


}
