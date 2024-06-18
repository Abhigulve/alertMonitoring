package org.monitoring.strategy;

import org.monitoring.model.Event;

public abstract class AlertingAlgoI {

    long maxThreshold;

    public AlertingAlgoI(long maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    public abstract boolean isThresholdBreached(Event event);


}
