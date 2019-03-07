package com.movix.localytics.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movix.localytics.utils.ResponseCode;

/**
 * 
 * @author dsepulveda
 *
 */
public class PushResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String message;
    private String error;
    private String responseCode;

    public PushResponse() {
        super();
    }

    public PushResponse(ResponseCode code) {
        super();
        this.responseCode = code.name();

        if (isSuccess()) {
            this.message = code.getMsg();
        }
        else {
            this.error = code.getMsg();
        }

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        this.responseCode = ResponseCode.OK.name();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
        this.responseCode = ResponseCode.ERROR.name();
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return responseCode.equals(ResponseCode.OK.name());
    }

}
