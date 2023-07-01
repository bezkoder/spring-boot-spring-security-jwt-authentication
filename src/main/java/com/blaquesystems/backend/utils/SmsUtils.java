package com.blaquesystems.backend.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsUtils {

    @Value("${bezkoder.app.sms.url}")
    private String url;

    @Value("${bezkoder.app.sms.apiClientID}")
    private int apiClientId;

    @Value("${bezkoder.app.sms.key}")
    private String key;

    @Value("${bezkoder.app.sms.secret}")
    private String secret;


    public String getFullSmsUrl(String message, Long msisdn, int serviceId) {
        return String.format("%sapiClientID=%d&key=%s&secret=%s&txtMessage=%s&MSISDN=%d&serviceID=%d",
                url, apiClientId, key, secret, message, msisdn, serviceId);
    }
}
