package com.clinicSystemService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ClinicAppointmentFilter {

    @JsonProperty(value = "appointmentDateFrom")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDateFrom;


    @JsonProperty(value = "appointmentDateTo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDateTo;


    public ClinicAppointmentFilter() {
    }

    public Date getAppointmentDateFrom() { return appointmentDateFrom; }

    public void setAppointmentDateFrom(Date appointmentDateFrom) {
        this.appointmentDateFrom = appointmentDateFrom;
    }

    public Date getAppointmentDateTo() {
        return appointmentDateTo;
    }

    public void setAppointmentDateTo(Date appointmentDateTo) {
        this.appointmentDateTo = appointmentDateTo;
    }
}
