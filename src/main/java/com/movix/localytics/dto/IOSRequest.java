package com.movix.localytics.dto;

import java.io.Serializable;

/**
 * 
 * @author dsepulveda
 *
 */
public class IOSRequest extends DeviceRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String sound = "default.wav";
    private int badge = 1;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

}
