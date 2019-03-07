package com.movix.localytics.dto;

/**
 * 
 * @author dsepulveda
 *
 */
public class MessageCustomerRequest extends MessageRequest {

    private static final long serialVersionUID = 1L;
    private String target;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
