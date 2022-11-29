/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicSystemService.repository;

import com.clinicSystemService.entity.Response;
import com.clinicSystemService.entity.cancelrequest.CancelAppointmentRequest;
import com.clinicSystemService.model.Appointment;
import com.clinicSystemService.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ClinicRepository {

    @Autowired
    private EntityManager entityManager;

    public void saveAppointment(Appointment appointment) {
        System.out.println("inside repo saveAppointment ");
        if (!ObjectUtils.isEmpty(appointment) && !entityManager.contains(appointment)) {
            entityManager.persist(appointment);
        }
        System.out.println("saveAppointment success");

    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointmentList = entityManager.createQuery("FROM Appointment app ")
                .getResultList();

        return appointmentList;

    }


    public Appointment getAppointmentById(Integer id) {
        Appointment appointment = (Appointment)
                entityManager.createQuery("FROM Appointment app where app.id= :id")
                        .setParameter("id", id)
                .getResultList().get(0);
        return appointment;
    }

    public Response updateAppointment(Appointment appointment,CancelAppointmentRequest request) {
        appointment.setAppointmentState(2);
        appointment.setCancelReason(request.getReason());
        entityManager.merge(appointment);
        return  new Response(200,"canceled successfully");
    }

    public List<Appointment> getAppointmentByDate(Date dateFrom,Date dateTo) {
        List<Appointment> appointmentList =
                entityManager.createQuery("FROM Appointment app " +
                        "where app.appointmentDate BETWEEN :dateFrom AND :dateTo ")
                        .setParameter("dateFrom",dateFrom)
                        .setParameter("dateTo", dateTo)
                .getResultList();

        return appointmentList;
    }

    public List<Appointment> getAppointmentByName(String sickName) {
        List<Appointment> appointmentList =null;
        List<Patient> patientList =
                entityManager.createQuery("from Patient p " +
                                "where p.sickName= :sickName")
                        .setParameter("sickName",sickName).getResultList();


        List<Integer> patientIdList = new ArrayList<Integer>();
        patientList.forEach(patient -> {
            patientIdList.add(patient.getId());
        });

        return appointmentList = entityManager.createQuery("FROM Appointment where  " +
                        " patientId in (:patientIdList) ")
                .setParameter("patientIdList", patientIdList).getResultList();


    }

    public Patient getPatientById(Integer patientId) {
        return (Patient) entityManager.createQuery("FROM Patient s WHERE s.id = :patientId")
                .setParameter("patientId", patientId)
                .getSingleResult();
    }

    public List<Appointment> getPatientHistoryBypatientId(Integer patientId) {
        return entityManager.createQuery("FROM Appointment app WHERE app.patientId = :patientId")
                .setParameter("patientId", patientId)
                .getResultList();
    }
}
