package com.novacomp.notifications.channel.email;

public class EmailConfig {

    private final String apiKey;
    private final String provider;

    public EmailConfig(String apiKey, String provider) {
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