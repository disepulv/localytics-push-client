package com.movix.localytics.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movix.localytics.enums.Scope;

/**
 * 
 * @author dsepulveda
 *
 */
public class CriteriaRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String key;
    private String scope = Scope.APP.getName();
    private String type = "string";
    private String operator = "in";
    private Scope scopeType;
    private List<String> values = new ArrayList<String>();

    public CriteriaRequest() {
        super();
    }

    public CriteriaRequest(String key, List<String> values) {
        super();
        this.key = key;
        this.values = values;
    }

    public CriteriaRequest(String key, List<String> values, Scope scope) {
        super();
        this.key = key;
        this.values = values;
        this.scope = scope.getName();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("op")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @JsonIgnore
    public Scope getScopeType() {
        return scopeType;
    }

    public void setScopeType(Scope scopeType) {
        this.scopeType = scopeType;
    }

}
