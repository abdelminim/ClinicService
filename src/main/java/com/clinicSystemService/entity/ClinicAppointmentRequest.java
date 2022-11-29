package com.clinicSystemService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class ClinicAppointmentRequest {

    @JsonProperty(value = "appointmentDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;

    @JsonProperty(value = "patientId")
    @ApiModelProperty(required = true)
    private Integer patientId;

    @JsonProperty(value = "placeOfDetection")
    private String placeOfDetection;

    public ClinicAppointmentRequest() {
    }

    public Date getAppointmentDate() { return appointmentDate; }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPlaceOfDetection() {
        return placeOfDetection;
    }

    public void setPlaceOfDetection(String placeOfDetection) {
        this.placeOfDetection = placeOfDetection;
    }

}
