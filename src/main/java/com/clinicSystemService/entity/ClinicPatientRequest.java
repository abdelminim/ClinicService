package com.clinicSystemService.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClinicPatientRequest {

    @JsonProperty(value = "patientId")
    @ApiModelProperty(required = true)
    private Integer id;

    @JsonProperty(value = "patientName")
    @ApiModelProperty(required = true)
    private String patientName;

    @JsonProperty(value = "patientName")
    private String patientAddress;

    @JsonProperty(value = "age")
    private Integer age;

    public ClinicPatientRequest() {
    }

}
