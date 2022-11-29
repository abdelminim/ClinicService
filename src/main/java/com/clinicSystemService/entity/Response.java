
package com.clinicSystemService.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Response {

    @ApiModelProperty(required = true)
    @JsonProperty("ResponseCode")
    private Integer responseCode;

    @JsonProperty("ResponseMessage")
    @ApiModelProperty(required = true)
    private String responseMessage;

    public Response() {
    }
    public Response(Integer responseCode) {
        this.responseCode = responseCode;
        this.responseMessage = ResponseCodes.getDesc(responseCode);
    }

    public Response(Integer responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
