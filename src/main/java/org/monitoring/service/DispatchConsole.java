package org.monitoring.service;

import org.monitoring.model.Event;

public class DispatchConsole implements DispatchI{

    public void dispatch(Event event) {
        System.out.println("Dispatching on Console");
        System.out.println("Client "+event.getClientID()+ " "+event.getEventType()+" threshold breached");
    }
}
