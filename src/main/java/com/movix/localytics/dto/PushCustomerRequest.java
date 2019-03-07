package com.movix.localytics.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movix.localytics.enums.Target;

/**
 * 
 * @author dsepulveda
 *
 */
public class PushCustomerRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String requestId;
    private String targetType = Target.CUSTOMER_ID.getName();
    private boolean allDevices = true;
    private List<MessageRequest> messages = new ArrayList<MessageRequest>();

    public PushCustomerRequest(String alert, String customerId) {
        super();
        this.requestId = UUID.randomUUID().toString();
        MessageCustomerRequest messageRequest = new MessageCustomerRequest();
        messageRequest.setAlert(alert);
        messageRequest.setTarget(customerId);
        messages.add(messageRequest);
    }

    public PushCustomerRequest(String alert, String customerId, Map<String, Object> extra) {
        super();
        this.requestId = UUID.randomUUID().toString();
        MessageCustomerRequest messageRequest = new MessageCustomerRequest();
        messageRequest.setAlert(alert);
        messageRequest.setTarget(customerId);

        if (extra != null) {
            messageRequest.getIos().setExtra(extra);
            messageRequest.getAndroid().setExtra(extra);
        }

        messages.add(messageRequest);
    }

    @JsonProperty("request_id")
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @JsonProperty("target_type")
    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    @JsonProperty("all_devices")
    public boolean isAllDevices() {
        return allDevices;
    }

    public void setAllDevices(boolean allDevices) {
        this.allDevices = allDevices;
    }

    public List<MessageRequest> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageRequest> messages) {
        this.messages = messages;
    }

    @JsonIgnore
    public void addMessage(String alert) {
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setAlert(alert);
        messages.add(messageRequest);
    }

}
