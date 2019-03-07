package com.movix.localytics.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movix.localytics.enums.Scope;

/**
 * 
 * @author dsepulveda
 *
 */
public class ProfileRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String operator = "and";
    private List<CriteriaRequest> criteria = new ArrayList<CriteriaRequest>();

    public ProfileRequest(CriteriaRequest criteria) {
        super();
        this.criteria.add(criteria);
    }

    public ProfileRequest(List<CriteriaRequest> criteria) {
        super();
        this.criteria = criteria;
    }

    public ProfileRequest(String key, List<String> values) {
        super();
        this.criteria.add(new CriteriaRequest(key, values, Scope.APP));
    }

    @JsonProperty("op")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<CriteriaRequest> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<CriteriaRequest> criteria) {
        this.criteria = criteria;
    }

}
