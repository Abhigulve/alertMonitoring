package org.example.service;

import org.example.model.AlertAlgoConfig;
import org.example.model.AlertConfiguration;
import org.example.model.DispatcherConfig;
import org.example.model.Event;

import java.util.List;
import java.util.Optional;

public class AlertConfigurationService {

    List<AlertConfiguration> alertConfigurationList;

    public AlertConfigurationService(List<AlertConfiguration> alertConfigurationList) {
        this.alertConfigurationList = alertConfigurationList;
    }

    public AlertAlgoConfig getAlertConfig(Event event) {
        for (AlertConfiguration alertConfiguration : alertConfigurationList) {
            if (alertConfiguration.getEventType().equals(event.getEventType())) {
                return alertConfiguration.getAlertConfig();
            }
        }
        return null;
    }


    public List<DispatcherConfig> getDispatcherConfig(Event event) {
        for (AlertConfiguration alertConfiguration : alertConfigurationList) {
            if (alertConfiguration.getEventType().equals(event.getEventType())) {
                return alertConfiguration.getDispatchStrategyList();
            }
        }
        return null;
    }

}
