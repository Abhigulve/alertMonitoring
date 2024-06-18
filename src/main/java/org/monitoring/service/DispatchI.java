package org.monitoring.service;

import org.monitoring.model.Event;

public interface DispatchI {

    public void dispatch(Event event);
}
