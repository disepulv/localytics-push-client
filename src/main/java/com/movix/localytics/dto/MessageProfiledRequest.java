package com.movix.localytics.dto;

import java.util.List;

/**
 * 
 * @author dsepulveda
 *
 */
public class MessageProfiledRequest extends MessageRequest {

    private static final long serialVersionUID = 1L;
    private TargetRequest target;

    public MessageProfiledRequest(String key, List<String> values) {
        super();
        ProfileRequest profile = new ProfileRequest(key, values);
        this.target = new TargetRequest(profile);
    }

    public TargetRequest getTarget() {
        return target;
    }

    public void setTarget(TargetRequest target) {
        this.target = target;
    }

}
