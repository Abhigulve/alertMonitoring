package org.example.model;

public class AlertAlgoConfig {
    String type;
    int count;
    int windowSizeInSecs;

    public AlertAlgoConfig(String type, int count, int windowSizeInSecs) {
        this.type = type;
        this.count = count;
        this.windowSizeInSecs = windowSizeInSecs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWindowSizeInSecs() {
        return windowSizeInSecs;
    }

    public void setWindowSizeInSecs(int windowSizeInSecs) {
        this.windowSizeInSecs = windowSizeInSecs;
    }
}
