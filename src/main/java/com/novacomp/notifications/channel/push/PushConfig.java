package com.novacomp.notifications.channel.push;

public class PushConfig {

    private final String apiKey;
    private final String provider;

    public PushConfig(String apiKey, String provider) {
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