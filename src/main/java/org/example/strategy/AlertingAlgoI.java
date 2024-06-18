package org.example.strategy;

import org.example.model.Event;
import org.example.model.EventType;

public abstract class AlertingAlgoI {

    long maxThreshold;

    public AlertingAlgoI(long maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    public abstract boolean isThresholdBreached(Event event);


}
