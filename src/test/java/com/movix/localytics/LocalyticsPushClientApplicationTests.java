package com.movix.localytics;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movix.localytics.conf.LocalyticsConfigurator;
import com.movix.localytics.dto.PushResponse;

/**
 *
 * @author dsepulveda
 *
 */
public class LocalyticsPushClientApplicationTests {

    // FOX INT
    final String urlIOS = "_https://messaging.localytics.com/v2/push/23752exxxxxxxxxxxx-652bfdc4-e3d7-11e6-b428-xxxxxxxxxxxx"; // ios
    final String urlAndroid = "_https://messaging.localytics.com/v2/push/c32403xxxxxxxxxxxx-555036da-e3d7-11e6-89cf-xxxxxxxxxxxx"; // android
    // PROD
    final String username = "xxxxxxxxxxxx-499c552c-fc41-11e5-163e-xxxxxxxxxxxx";
    final String password = "xxxxxxxxxxxx-499c5808-fc41-11e5-163e-xxxxxxxxxxxx";

    private LocalyticsConfigurator configuratorAndroid;
    private LocalyticsConfigurator configuratorIOS;

    private static final Logger logger = LoggerFactory.getLogger(LocalyticsPushClientApplicationTests.class);

    @Before
    public void setUp() {
        configuratorAndroid = new LocalyticsConfigurator(urlAndroid, username, password);
        configuratorIOS = new LocalyticsConfigurator(urlIOS, username, password);
    }

    @Test
    @Ignore
    public void sendTargeredTest() {
        try {
            String alert = "Mensaje de prueba dirigida [12]";

            Map<String, Object> extra = new HashMap<String, Object>();
            {
                extra.put("value", "push");
                extra.put("key", "delivery_type");
            }

            PushResponse response1 = new LocalyticsRestClient(configuratorIOS).sendCustomerPush(alert, "56900000002", extra);
            Assert.assertNotNull("Result is null", response1);
            Assert.assertNotNull("Success result is nulo", response1.getMessage());
            logger.info(response1.getMessage());

            PushResponse response2 = new LocalyticsRestClient(configuratorAndroid).sendCustomerPush(alert, "56900000002",
                    extra);
            Assert.assertNotNull("Result is null", response2);
            Assert.assertNotNull("Success result is nulo", response2.getMessage());
            logger.info(response2.getMessage());

        }
        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    // @Ignore
    public void sendTargeredIOSTest() {
        try {
            String alert = "Mensaje de prueba dirigida [11]";

            Map<String, Object> extra = new HashMap<String, Object>();
            {
                extra.put("value", "push");
                extra.put("key", "delivery_type");
            }

            PushResponse response1 = new LocalyticsRestClient(configuratorIOS).sendCustomerPush(alert, "593985980710", extra);
            Assert.assertNotNull("Result is null", response1);
            Assert.assertNotNull("Success result is nulo", response1.getMessage());
            logger.info(response1.getMessage());

        }
        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Ignore
    public void sendBroadcastTest() {
        try {
            String alert = "Mensaje de prueba - Masivo [011]";
            PushResponse response = new LocalyticsRestClient(configuratorAndroid).sendBroadcastPush(alert);
            Assert.assertNotNull("Result is null", response);
            Assert.assertNotNull("Success result is nulo", response.getMessage());
            logger.info(response.getMessage());

            PushResponse response2 = new LocalyticsRestClient(configuratorIOS).sendBroadcastPush(alert);
            Assert.assertNotNull("Result is null", response2);
            Assert.assertNotNull("Success result is nulo", response2.getMessage());
            logger.info(response2.getMessage());

            PushResponse errorResponse = new LocalyticsRestClient(configuratorAndroid).sendBroadcastPush(null);
            Assert.assertNotNull("Result is null", errorResponse);
            Assert.assertNotNull("Fail result is null", errorResponse.getError());
            logger.info(errorResponse.getError());

        }
        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    // @Ignore
    public void sendBroadcastIOSTest() {
        try {
            String alert = "Mensaje de prueba iOS [0005]";

            PushResponse response2 = new LocalyticsRestClient(configuratorIOS).sendBroadcastPush(alert);
            Assert.assertNotNull("Result is null", response2);
            Assert.assertNotNull("Success result is nulo", response2.getMessage());
            logger.info(response2.getMessage());

        }
        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Ignore
    public void sendBroadcastAndroidTest() {
        try {
            String alert = "Mensaje de prueba - Masivo [007]";
            PushResponse response = new LocalyticsRestClient(configuratorAndroid).sendBroadcastPush(alert);
            Assert.assertNotNull("Result is null", response);
            Assert.assertNotNull("Success result is nulo", response.getMessage());
            logger.info(response.getMessage());

        }
        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    // @Ignore
    public void sendProfiledTest() {
        try {

            String campaignKey = "ANDROID_" + new Date().getTime();
            campaignKey = campaignKey.replaceAll("\\s", "");

            System.out.println(campaignKey);
            String alert = "Delivered by Profiled - Movix test [104] - Video ID";
            String key = "team";

            String[] values = { "ARG_Banfield", "GLO_CONCACAF Champions League" };
            Map<String, Object> extra = new HashMap<String, Object>();
            {
                extra.put("videoId", "875624003689");
                extra.put("videoId2", "7742674595250");
            }

            PushResponse response = new LocalyticsRestClient(configuratorAndroid).sendProfiledPush(alert, key,
                    Arrays.asList(values), campaignKey, extra);
            Assert.assertNotNull("Result is null", response);
            Assert.assertTrue("Result is unsuccess ->" + response.getError(), response.isSuccess());
            Assert.assertNotNull("Success result is nulo", response.getMessage());
            logger.info(response.getMessage());

            PushResponse errorResponse = new LocalyticsRestClient(configuratorAndroid).sendProfiledPush(null, null, null, null);
            Assert.assertNotNull("Result is null", errorResponse);
            Assert.assertNotNull("Fail result is null", errorResponse.getError());
            logger.info(errorResponse.getError());

        }
        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    // @Ignore
    public void sendNewProfiledTest() {
        try {

            String campaignKey = campaignCreator("CHI MOVIX");

            System.out.println(campaignKey);
            String alert = "Mensaje de prueba - Perfilado [000] - Video ID";
            String key = "team";

            // String[] values = { "TEST_CLARO_CO" };
            String[] values = { "ARG_Banfield", "GLO_CONCACAF Champions League" };
            Map<String, Object> extra = new HashMap<String, Object>();
            {
                extra.put("value", "875624003689");
                extra.put("key", "videoId");
            }

            PushResponse response = new LocalyticsRestClient(configuratorAndroid).sendProfiledPush(alert, key,
                    Arrays.asList(values), campaignKey, extra);
            Assert.assertNotNull("Result is null", response);
            Assert.assertTrue("Result is unsuccess ->" + response.getError(), response.isSuccess());
            Assert.assertNotNull("Success result is nulo", response.getMessage());
            logger.info(response.getMessage());

            PushResponse response2 = new LocalyticsRestClient(configuratorIOS).sendProfiledPush(alert, key,
                    Arrays.asList(values), campaignKey, extra);
            Assert.assertNotNull("Result is null", response2);
            Assert.assertTrue("Result is unsuccess ->" + response2.getError(), response2.isSuccess());
            Assert.assertNotNull("Success result is nulo", response2.getMessage());
            logger.info(response2.getMessage());

            PushResponse errorResponse = new LocalyticsRestClient(configuratorAndroid).sendProfiledPush(null, null, null, null);
            Assert.assertNotNull("Result is null", errorResponse);
            Assert.assertNotNull("Fail result is null", errorResponse.getError());
            logger.info(errorResponse.getError());

        }
        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    private String campaignCreator(String competition) {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        String campaignKeyPostfix = formatter.format(today);

        String campaignKey = competition.trim();
        campaignKey = campaignKey.replaceAll("\\s+", "_");
        campaignKey += "_" + campaignKeyPostfix;

        return campaignKey;
    }

}
