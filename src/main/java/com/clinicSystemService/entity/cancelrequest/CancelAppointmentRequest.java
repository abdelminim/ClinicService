
package com.clinicSystemService.entity.cancelrequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class CancelAppointmentRequest {

    @ApiModelProperty(required = true)
    @JsonProperty(value = "appointmentId")
    private String appointmentId;

    @JsonProperty(value = "Reason")
    private String reason;

    public CancelAppointmentRequest() {

    }

}
