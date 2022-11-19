package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.AppointmentDto;
import com.ghinaglam.ghinaglam.model.Appointment;
import com.ghinaglam.ghinaglam.model.Client;
import com.ghinaglam.ghinaglam.model.Plan;
import com.ghinaglam.ghinaglam.model.Status;
import com.ghinaglam.ghinaglam.repository.AppointmentRepository;
import com.ghinaglam.ghinaglam.repository.ClientRepository;
import com.ghinaglam.ghinaglam.repository.PlanRepository;
import com.ghinaglam.ghinaglam.service.AppointmentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ClientRepository clientRepository;
    private final PlanRepository planRepository;

    private final ModelMapper mapper = new ModelMapper();


    @Override
    public AppointmentDto createAppointment(Long clientId, Long planId,
                                            AppointmentDto appointmentDto) {
        Appointment appointment = mapToEntity(appointmentDto);
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalStateException("Client with the id" + clientId + " not found"));
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new IllegalStateException("No plan found"));
        appointment.setClient(client);
        appointment.setPlan(plan);
        appointment.setStatus(Status.STARTED);

        return mapToDto(appointmentRepository.save(appointment));
    }

    @Override
    @Transactional
    public AppointmentDto updateAppointmentStatus(Long appointmentId, Status status) {
            Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new IllegalStateException("Appointment does not exist"));
            appointment.setStatus(status);
            return mapToDto(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() { //Only Admin is authorized to perform this action
        return appointmentRepository.findAll();
    }
    @Override
    public void getAppointmentById(Long appointmentId) {
        appointmentRepository.findById(appointmentId);
    }

    @Override
    public List<AppointmentDto> getAppointmentByStatus(Status status) {
        return appointmentRepository.findAppointmentByStatus(status).stream().map(this::mapToDto).toList();
    }
    @Override
    public List<Appointment> getAppointmentByStartDate(LocalDate startDate) {
        return appointmentRepository.findAppointmentByStartDate(startDate);
    }


    private AppointmentDto mapToDto(Appointment appointment) {
        return mapper.map(appointment, AppointmentDto.class);
    }
    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        return mapper.map(appointmentDto, Appointment.class);
    }

}
