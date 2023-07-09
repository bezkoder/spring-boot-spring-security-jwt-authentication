package com.blaquesystems.backend.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsUtils {

    @Value("${sms.url}")
    private String url;

    @Value("${sms.apiClientID}")
    private int apiClientId;

    @Value("${sms.key}")
    private String key;

    @Value("${sms.secret}")
    private String secret;


    public String getFullSmsUrl(String message, Long msisdn, int serviceId) {
        return String.format("%sapiClientID=%d&key=%s&secret=%s&txtMessage=%s&MSISDN=%d&serviceID=%d",
                url, apiClientId, key, secret, message, msisdn, serviceId);
    }
}
