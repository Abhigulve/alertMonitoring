package org.example.async;

import org.example.model.Event;
import org.example.service.MonitoringService;

public class AlertsConsumer implements Subscriber {
    MonitoringService monitoringService;

    public AlertsConsumer(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @Override
    public void update(Event event) {
        monitoringService.processEvent(event);
    }
}
