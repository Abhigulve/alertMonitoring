package org.example.async;


import org.example.model.Event;
import org.example.model.EventType;

import java.util.ArrayList;
import java.util.List;

public interface Publisher {
    List<Subscriber> subscribers = new ArrayList<>();

    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void publishMessage(Event event);
}
