package org.monitoring.model;

public class Window {
    private long startTime;
    private int alertCount;

    public Window(long startTime, int alertCount) {
        this.startTime = startTime;
        this.alertCount = alertCount;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }
}
