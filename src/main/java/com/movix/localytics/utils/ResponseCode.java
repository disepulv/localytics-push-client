package com.movix.localytics.utils;

/**
 * 
 * @author dsepulveda
 *
 */
public enum ResponseCode {
    OK("OK"), ERROR("Error inesperado"), INVALID_PARAMS("Parametros invalidos");

    private String msg;

    private ResponseCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
