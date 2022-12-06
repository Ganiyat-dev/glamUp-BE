package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.AppointmentDto;
import com.ghinaglam.ghinaglam.model.Appointment;
import com.ghinaglam.ghinaglam.model.Status;
import com.ghinaglam.ghinaglam.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/{userId}/{planId}")
    public ResponseEntity<AppointmentDto> createAppointment(@PathVariable("userId") Long userId,
                                                            @PathVariable("planId") Long planId,
                                                            @RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.ok().body(appointmentService.createAppointment(userId, planId, appointmentDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return ResponseEntity.ok().body(appointmentService.getAllAppointments());
    }

//    @GetMapping("/status/{status}")
//    public ResponseEntity<List<AppointmentDto>> getAppointmentByStatus(@PathVariable("status") Status status) {
//        return ResponseEntity.ok().body(appointmentService.getAppointmentByStatus(status));
//
//    }
    @GetMapping("/date/{date}")
    public ResponseEntity<List<Appointment>> getAppointmentByStartDate(@PathVariable("date") LocalDate startDate) {
        return ResponseEntity.ok().body(appointmentService.getAppointmentByStartDate(startDate) );

    }
//    @PatchMapping("/{appointmentId}/status/{status}")
//    public ResponseEntity<AppointmentDto> updateAppointmentStatus(@PathVariable("appointmentId") Long appointmentId, @PathVariable("status") Status status) {
//        return ResponseEntity.ok().body(appointmentService.updateAppointmentStatus(appointmentId, status));
//    }
}
