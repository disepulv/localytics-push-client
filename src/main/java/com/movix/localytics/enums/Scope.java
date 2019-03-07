package com.movix.localytics.enums;

/**
 * 
 * @author dsepulveda
 *
 */
public enum Scope {

    APP("LocalyticsApplication"), ORG("Organization");

    private String name;

    Scope(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
