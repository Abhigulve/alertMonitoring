package org.monitoring.async;

import org.monitoring.model.Event;

public interface Subscriber {
    void update(Event event);
}
