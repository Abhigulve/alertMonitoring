package org.monitoring.strategy;

import org.monitoring.model.Event;
import org.monitoring.model.Window;

import java.time.Duration;

public class TumblingWindowImpl extends AlertingAlgoI {
    private final long windowSizeInMillis;
    private Window window;

    TumblingWindowImpl(long maxCountAllowed, long windowSizeInMillis) {
        super(maxCountAllowed);
        this.windowSizeInMillis = windowSizeInMillis;
        window = new Window(System.currentTimeMillis(), 0);
    }


    @Override
    public boolean isThresholdBreached(Event event) {

        long currentTimeMillis = System.currentTimeMillis();
        if( currentTimeMillis - window.getStartTime() < Duration.ofSeconds(windowSizeInMillis).toMillis() && window.getAlertCount() >this.maxThreshold) {
//            String startTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(window.getStartTime()),
//                    TimeUnit.MILLISECONDS.toMinutes(window.getStartTime()) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(window.getStartTime())),
//                    TimeUnit.MILLISECONDS.toSeconds(window.getStartTime()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(window.getStartTime())));
//
//            String endTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(currentTimeMillis),
//                    TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(currentTimeMillis)),
//                    TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis)));
//
//            System.out.println(startTime +" "+endTime);
            return true;
        }
        if(currentTimeMillis - window.getStartTime() > Duration.ofSeconds(windowSizeInMillis).toMillis()) {
            window.setStartTime(currentTimeMillis);
            window.setAlertCount(0);
        }
        int count = window.getAlertCount() ;
        window.setAlertCount(++count);
        System.out.println(window.getAlertCount());
        return false;
    }

}
