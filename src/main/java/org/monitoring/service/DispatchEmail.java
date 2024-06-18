package org.monitoring.service;

import org.monitoring.model.Event;

public class DispatchEmail implements DispatchI{
    @Override
    public void dispatch(Event event) {
        System.out.println("Dispatching an Email");
        System.out.println("Client "+event.getClientID()+ " "+event.getEventType()+" threshold breached");
    }
}
