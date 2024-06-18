package org.example.model;

import com.google.gson.annotations.SerializedName;

import java.security.spec.ECField;
import java.util.List;

public class AlertConfiguration {
    @SerializedName("client")
    private String client;

    @SerializedName("eventType")
    private EventType eventType;

    @SerializedName("alertConfig")
    private AlertAlgoConfig alertConfig;

    @SerializedName("dispatchStrategyList")
    private List<DispatcherConfig> dispatchStrategyList;

    // Getters and setters
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public AlertAlgoConfig getAlertConfig() {
        return alertConfig;
    }

    public void setAlertConfig(AlertAlgoConfig alertConfig) {
        this.alertConfig = alertConfig;
    }

    public List<DispatcherConfig> getDispatchStrategyList() {
        return dispatchStrategyList;
    }

    public void setDispatchStrategyList(List<DispatcherConfig> dispatchStrategyList) {
        this.dispatchStrategyList = dispatchStrategyList;
    }
}
