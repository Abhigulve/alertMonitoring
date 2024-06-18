package org.monitoring.strategy;

import org.monitoring.model.AlertAlgoConfig;

import java.util.HashMap;
import java.util.Map;

public class AlgoFactory {
    static Map<String, AlertingAlgoI> map = new HashMap<>();

    public static AlertingAlgoI getAlgorithm(AlertAlgoConfig config) {
        if (!map.containsKey(config.getType()))
            map.put(config.getType(), getAlgo(config));

        return map.get(config.getType());
    }

    private static AlertingAlgoI getAlgo(AlertAlgoConfig config) {
        switch (config.getType()) {
            case "TUMBLING_WINDOW":
                return new TumblingWindowImpl(config.getCount(), config.getWindowSizeInSecs());
            case "SLIDING_WINDOW":
                return new SlidingWindowImpl(config.getCount(), config.getWindowSizeInSecs());
            case "SIMPLE_COUNT":
                return new SimpleCountImpl(config.getCount());
            default:
                return null;
        }
    }
}
