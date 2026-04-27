package com.novacomp.notifications.channel.sms;

public class SmsConfig {

    private final String apiKey;
    private final String provider;

    public SmsConfig(String apiKey, String provider) {
        this.apiKey = apiKey;
        this.provider = provider;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getProvider() {
        return provider;
    }
}