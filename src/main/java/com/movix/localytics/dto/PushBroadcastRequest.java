package com.movix.localytics.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movix.localytics.enums.Target;

/**
 * 
 * @author dsepulveda
 *
 */
public class PushBroadcastRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String requestId;
    private String targetType = Target.BROADCAST.getName();
    private List<MessageRequest> messages = new ArrayList<MessageRequest>();

    public PushBroadcastRequest(String alert) {
        super();
        this.requestId = UUID.randomUUID().toString();
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setAlert(alert);
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
