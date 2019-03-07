package com.movix.localytics.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author dsepulveda
 *
 */
public class DeviceRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private Map<String, Object> extra;

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

}
