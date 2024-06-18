package org.example.service;

import org.example.model.AlertAlgoConfig;
import org.example.model.DispatcherConfig;
import org.example.model.Event;
import org.example.model.EventType;
import org.example.strategy.AlertingAlgoI;
import org.example.strategy.AlgoFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonitoringService {

    AlertConfigurationService alertConfigurationService;

    public MonitoringService(AlertConfigurationService alertConfigurationService) {
        this.alertConfigurationService = alertConfigurationService;
    }

    public void processEvent(Event event) {
        AlertAlgoConfig alertAlgoConfig = alertConfigurationService.getAlertConfig(event);
        AlertingAlgoI alertingAlgoI = AlgoFactory.getAlgorithm(alertAlgoConfig);
        if (alertingAlgoI.isThresholdBreached(event)) {
            List<DispatcherConfig> dispatcherConfigs = alertConfigurationService.getDispatcherConfig(event);
            dispatcherConfigs.stream().forEach(d->DispatcherFactory.getDispatcher(d.getType()).dispatch(event));
        }
    }
}
