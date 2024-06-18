package org.monitoring.service;

import org.monitoring.model.AlertAlgoConfig;
import org.monitoring.model.AlertConfiguration;
import org.monitoring.model.DispatcherConfig;
import org.monitoring.model.Event;

import java.util.List;

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
