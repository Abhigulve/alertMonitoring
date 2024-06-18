package org.monitoring.service;

import org.monitoring.model.DispatchType;

public class DispatcherFactory {


    public static DispatchI getDispatcher(DispatchType dispatchType) {
        switch (dispatchType) {
            case DispatchType.CONSOLE:
                return new DispatchConsole();
            case DispatchType.EMAIL:
                return new DispatchEmail();
            default:
                return new DispatchConsole();
        }
    }
}
