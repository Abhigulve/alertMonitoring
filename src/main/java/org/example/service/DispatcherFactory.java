package org.example.service;

import org.example.model.AlertAlgoConfig;
import org.example.model.DispatchType;
import org.example.strategy.AlertingAlgoI;
import org.example.strategy.SimpleCountImpl;
import org.example.strategy.SlidingWindowImpl;

import java.util.HashMap;
import java.util.Map;

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
