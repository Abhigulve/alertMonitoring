package org.example.async;

import org.example.model.Event;

public interface Subscriber {
    void update(Event event);
}
