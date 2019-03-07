package com.movix.localytics.dto;

import java.io.Serializable;

/**
 * 
 * @author dsepulveda
 *
 */
public class MessageRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String alert;
    private IOSRequest ios = new IOSRequest();
    private AndroidRequest android = new AndroidRequest();

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public IOSRequest getIos() {
        return ios;
    }

    public void setIos(IOSRequest ios) {
        this.ios = ios;
    }

    public AndroidRequest getAndroid() {
        return android;
    }

    public void setAndroid(AndroidRequest android) {
        this.android = android;
    }

}
