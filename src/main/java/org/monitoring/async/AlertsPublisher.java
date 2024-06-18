package org.monitoring.async;

import org.monitoring.model.Event;

public class AlertsPublisher implements Publisher {
    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void publishMessage(Event event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(event);
        }
    }
}
