package org.monitoring.strategy;

import org.monitoring.model.Event;

import java.util.HashMap;
import java.util.Map;

public class SimpleCountImpl extends AlertingAlgoI {

    private final Map<String, Long> map = new HashMap<>();

    SimpleCountImpl(long maxCountAllowed) {
        super(maxCountAllowed);
    }

    @Override
    public boolean isThresholdBreached(Event event) {
        String key = event.getClientID();
        long currentCount = map.getOrDefault(key, 0L);
        if (map.get(key) != null &&  map.get(key) >= maxThreshold) {
            return true;
        }
        map.put(key, currentCount + 1);
        return false;
    }
}
