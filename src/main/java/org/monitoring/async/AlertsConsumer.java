package org.monitoring.async;

import org.monitoring.model.Event;
import org.monitoring.service.MonitoringService;

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
