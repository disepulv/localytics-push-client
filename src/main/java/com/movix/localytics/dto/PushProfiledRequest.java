package com.movix.localytics.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movix.localytics.enums.Target;

/**
 * 
 * @author dsepulveda
 *
 */
public class PushProfiledRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String requestId;
    private String campaignKey; // optional
    private String targetType = Target.PROFILE.getName();
    private boolean allDevices = true;
    private List<MessageProfiledRequest> messages = new ArrayList<MessageProfiledRequest>();

    public PushProfiledRequest(String alert, String key, List<String> values, String campaignKey) {
        super();
        this.requestId = UUID.randomUUID().toString();
        this.campaignKey = campaignKey;

        MessageProfiledRequest messageRequest = new MessageProfiledRequest(key, values);
        messageRequest.setAlert(alert);
        messages.add(messageRequest);
    }

    public PushProfiledRequest(String alert, String key, List<String> values, String campaignKey, Map<String, Object> extra) {
        super();
        this.requestId = UUID.randomUUID().toString();
        this.campaignKey = campaignKey;

        MessageProfiledRequest messageRequest = new MessageProfiledRequest(key, values);
        messageRequest.setAlert(alert);

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

    @JsonProperty("campaign_key")
    public String getCampaignKey() {
        return campaignKey;
    }

    public void setCampaignKey(String campaignKey) {
        this.campaignKey = campaignKey;
    }

    @JsonProperty("target_type")
    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public List<MessageProfiledRequest> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageProfiledRequest> messages) {
        this.messages = messages;
    }

    @JsonProperty("all_devices")
    public boolean isAllDevices() {
        return allDevices;
    }

    public void setAllDevices(boolean allDevices) {
        this.allDevices = allDevices;
    }

}
