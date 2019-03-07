package com.movix.localytics.enums;

/**
 * 
 * @author dsepulveda
 *
 */
public enum Target {

    PROFILE("profile"), BROADCAST("broadcast"), CUSTOMER_ID("customer_id");

    private String name;

    Target(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
