/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicSystemService.service;

import com.clinicSystemService.entity.ClinicAppointmentFilter;
import com.clinicSystemService.entity.ClinicAppointmentRequest;
import com.clinicSystemService.entity.Response;
import com.clinicSystemService.entity.ResponseCodes;
import com.clinicSystemService.entity.cancelrequest.CancelAppointmentRequest;
import com.clinicSystemService.model.Appointment;
import com.clinicSystemService.model.Patient;
import com.clinicSystemService.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;



    public List<Appointment> getAllAppointments() {
        return clinicRepository.getAllAppointments();
    }

    public Response cancelAppointMent(CancelAppointmentRequest cancelRequest) {
        Response response = null;
        Appointment appointment = clinicRepository.getAppointmentById(Integer.parseInt(
                cancelRequest.getAppointmentId()));
        if(appointment!=null && appointment.getId()!=0){
              response = clinicRepository.updateAppointment(appointment,cancelRequest);
        }else
            response = new Response(201,"Appointment not found");

        return response;
    }

    public Response createNewAppointment(ClinicAppointmentRequest appointmentRequest) {
        Response response = new Response();
        Patient patient = clinicRepository.getPatientById(appointmentRequest.getPatientId());
        if(patient==null)
            return new Response(ResponseCodes.noDataFound, "Patient not found");
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setPatientId(appointmentRequest.getPatientId());
        appointment.setPlaceOfDetection(appointmentRequest.getPlaceOfDetection());
//        appointment.setPatient(patient);
        clinicRepository.saveAppointment(appointment);
        response.setResponseCode(ResponseCodes.success);
        response.setResponseMessage("create Appointment successFuly");
        return response;
    }

    public List<Appointment> getAppointmentByDate(ClinicAppointmentFilter appointmentFilter) throws ParseException {
        return clinicRepository.getAppointmentByDate(
                appointmentFilter.getAppointmentDateFrom(),appointmentFilter.getAppointmentDateTo());
    }

    public List<Appointment> getAppointmentByPatientName(String patientName) {
        return clinicRepository.getAppointmentByName(patientName);
    }

    public List<Appointment> getPatientHistoryBypatientId(Integer patientId) {
        return clinicRepository.getPatientHistoryBypatientId(patientId);
    }
}