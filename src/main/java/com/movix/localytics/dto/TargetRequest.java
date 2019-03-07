package com.movix.localytics.dto;

import java.io.Serializable;

/**
 * 
 * @author dsepulveda
 *
 */
public class TargetRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private ProfileRequest profile;

    public TargetRequest(ProfileRequest profile) {
        super();
        this.profile = profile;
    }

    public ProfileRequest getProfile() {
        return profile;
    }

    public void setProfile(ProfileRequest profile) {
        this.profile = profile;
    }

}
