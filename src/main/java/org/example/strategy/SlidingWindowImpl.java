package org.example.strategy;

import org.example.model.Event;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class SlidingWindowImpl extends AlertingAlgoI {
    private final long windowSizeInMillis;
    private int previousWindowNum;
    private int count;
    private final Duration WIN_SIZE;


    public SlidingWindowImpl(long maxCountAllowed, long windowSizeInMillis) {
        super(maxCountAllowed);
        this.windowSizeInMillis = windowSizeInMillis;
        this.previousWindowNum = 1;
        this.count = 1;
        this.WIN_SIZE = Duration.ofSeconds(windowSizeInMillis);
    }

    @Override
    public boolean isThresholdBreached(Event event) {
        int currentWindowNum = (int) (event.getTimestamp() / WIN_SIZE.toMillis());
        if (currentWindowNum > previousWindowNum) {
            this.previousWindowNum = currentWindowNum;
            this.count = 0;
        }
        this.count++;
        return count>maxThreshold;
    }
}
