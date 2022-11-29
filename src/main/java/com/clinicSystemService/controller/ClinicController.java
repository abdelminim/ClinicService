
package com.clinicSystemService.controller;

import com.clinicSystemService.entity.ClinicAppointmentFilter;
import com.clinicSystemService.entity.ClinicAppointmentRequest;
import com.clinicSystemService.entity.Response;
import com.clinicSystemService.entity.cancelrequest.CancelAppointmentRequest;
import com.clinicSystemService.model.Appointment;
import com.clinicSystemService.model.Patient;
import com.clinicSystemService.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/", consumes = "application/json", produces = "application/json")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping(value = "/getAllAppointments")
    public List<Appointment> getAllAppointments() {
        return clinicService.getAllAppointments();
    }

    @PostMapping(value = "/createNewAppointment")
    public Response createNewAppointment(@RequestBody ClinicAppointmentRequest appointmentRequest) {
        return clinicService.createNewAppointment(appointmentRequest);
    }

    @PostMapping(value = "/cancelAppointMent/{id}")
    public Response cancelAppointMent(@RequestBody CancelAppointmentRequest cancelRequest) {
        return clinicService.cancelAppointMent(cancelRequest);
    }

    @PostMapping(value = "/getAppointmentByDate")
    public List<Appointment> getAppointmentByDate(@RequestBody ClinicAppointmentFilter appointmentFilter) throws ParseException {
        return clinicService.getAppointmentByDate(appointmentFilter);
    }

    @PostMapping(value = "/getAppointmentByPatientName")
    public List<Appointment> getAppointmentByPatientName(@RequestParam String patientName) {
        return clinicService.getAppointmentByPatientName(patientName);
    }


    @PostMapping(value = "/getPatientHistoryBypatientId")
    public List<Appointment> getPatientHistoryBypatientId(@RequestParam Integer patientId) {
        return clinicService.getPatientHistoryBypatientId(patientId);
    }

}
