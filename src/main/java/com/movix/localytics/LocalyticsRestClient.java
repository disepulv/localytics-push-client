package com.movix.localytics;

import java.util.List;
import java.util.Map;

import org.restlet.Context;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movix.localytics.conf.LocalyticsConfigurator;
import com.movix.localytics.dto.PushBroadcastRequest;
import com.movix.localytics.dto.PushCustomerRequest;
import com.movix.localytics.dto.PushProfiledRequest;
import com.movix.localytics.dto.PushResponse;
import com.movix.localytics.utils.ResponseCode;

/**
 *
 * Class that allows send push notifications throght Localytics API
 *
 * @author dsepulveda
 *
 */
public class LocalyticsRestClient {

    private LocalyticsConfigurator configurator;
    private int httpRequestTimeoutMilliSeconds = 60000;

    private static final Logger logger = LoggerFactory.getLogger(LocalyticsRestClient.class);

    public LocalyticsRestClient() {
        super();
    }

    public LocalyticsRestClient(LocalyticsConfigurator configurator) {
        this.setConfigurator(configurator);
    }

    private Context getContext() {
        Context context = new Context();
        context.getParameters().add("socketConnectTimeoutMs", String.valueOf(httpRequestTimeoutMilliSeconds));
        return context;
    }

    private PushResponse sendBroadcastPush(PushBroadcastRequest request) {
        ClientResource clientResource = new ClientResource(getContext(), configurator.getUrl());
        clientResource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, configurator.getUsername(), configurator.getPassword());
        PushResponse response;
        try {
            response = clientResource.post(request, PushResponse.class);
        }
        catch (ResourceException e) {
            logger.error("sendBroadcastPush|message={}", e.getMessage(), e);
            response = new PushResponse();
            response.setError(e.getMessage());
        }

        return response;
    }

    /**
     * Method that allows send push notification of type: 'broadcast'
     * 
     * @param alert
     *            alert
     * @return response from Localytics API
     */
    public PushResponse sendBroadcastPush(String alert) {
        if (alert == null) {
            return new PushResponse(ResponseCode.INVALID_PARAMS);
        }

        return sendBroadcastPush(new PushBroadcastRequest(alert));
    }

    private PushResponse sendProfiledPush(PushProfiledRequest request) {

        ClientResource clientResource = new ClientResource(getContext(), configurator.getUrl());
        clientResource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, configurator.getUsername(), configurator.getPassword());
        PushResponse response;
        try {
            response = clientResource.post(request, PushResponse.class);
        }
        catch (ResourceException e) {
            logger.error("sendProfiledPush|message={}", e.getMessage(), e);
            response = new PushResponse();
            response.setError(e.getMessage());
        }

        return response;
    }

    /**
     * 
     * Method that allows send push notification of type: 'profile'
     * 
     * @param alert
     *            alert message
     * @param key
     *            key for set of tags
     * @param values
     *            tags that user has suscribed
     * @param campaignKey
     *            campaign key or name for dashboard
     * @return response from Localytics API
     */
    public PushResponse sendProfiledPush(String alert, String key, List<String> values, String campaignKey) {
        return sendProfiledPush(alert, key, values, campaignKey, null);
    }

    /**
     * 
     * Method that allows send push notification of type: 'profile'
     * 
     * @param alert
     *            alert message
     * @param key
     *            key for set of tags
     * @param values
     *            tags that user has suscribed
     * @param campaignKey
     *            campaign key or name for dashboard
     * @param extra
     *            map with extra data
     * @return response from Localytics API
     */
    public PushResponse sendProfiledPush(String alert, String key, List<String> values, String campaignKey,
            Map<String, Object> extra) {
        if (alert == null || key == null || values == null || campaignKey == null) {
            return new PushResponse(ResponseCode.INVALID_PARAMS);
        }

        return sendProfiledPush(new PushProfiledRequest(alert, key, values, campaignKey, extra));
    }

    private PushResponse sendCustomerPush(PushCustomerRequest request) {

        ClientResource clientResource = new ClientResource(getContext(), configurator.getUrl());
        clientResource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, configurator.getUsername(), configurator.getPassword());
        PushResponse response;
        try {
            response = clientResource.post(request, PushResponse.class);
        }
        catch (ResourceException e) {
            logger.error("sendProfiledPush|message={}", e.getMessage(), e);
            response = new PushResponse();
            response.setError(e.getMessage());
        }

        return response;
    }

    /**
     * 
     * Method that allows send push notification of type: 'profile'
     * 
     * @param alert
     *            alert message
     * @param customerId
     *            customer identifier
     * @param extra
     *            extra data
     * @return response from Localytics API
     */
    public PushResponse sendCustomerPush(String alert, String customerId, Map<String, Object> extra) {
        if (customerId == null) {
            return new PushResponse(ResponseCode.INVALID_PARAMS);
        }

        if (alert == null) {
            alert = "";
        }

        return sendCustomerPush(new PushCustomerRequest(alert, customerId, extra));
    }

    public int getHttpRequestTimeoutMilliSeconds() {
        return httpRequestTimeoutMilliSeconds;
    }

    public void setHttpRequestTimeoutMilliSeconds(int httpRequestTimeoutMilliSeconds) {
        this.httpRequestTimeoutMilliSeconds = httpRequestTimeoutMilliSeconds;
    }

    public LocalyticsConfigurator getConfigurator() {
        return configurator;
    }

    public void setConfigurator(LocalyticsConfigurator configurator) {
        this.configurator = configurator;
    }

}
