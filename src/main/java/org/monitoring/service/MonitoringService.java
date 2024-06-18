package org.monitoring.service;

import org.monitoring.model.AlertAlgoConfig;
import org.monitoring.model.DispatcherConfig;
import org.monitoring.model.Event;
import org.monitoring.strategy.AlertingAlgoI;
import org.monitoring.strategy.AlgoFactory;

import java.util.List;

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
