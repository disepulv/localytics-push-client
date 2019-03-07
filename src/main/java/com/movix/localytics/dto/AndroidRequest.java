package com.movix.localytics.dto;

import java.io.Serializable;

/**
 * 
 * @author dsepulveda
 *
 */
public class AndroidRequest extends DeviceRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String priority = "high";

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
