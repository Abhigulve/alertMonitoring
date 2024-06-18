package org.example.model;

import java.util.Map;

public class DispatcherConfig {
    private DispatchType type;
    private Map<String, String> content;

    public DispatcherConfig(DispatchType type, Map<String, String> content) {
        this.type = type;
        this.content = content;
    }

    public DispatchType getType() {
        return type;
    }

    public void setType(DispatchType type) {
        this.type = type;
    }

    public Map<String, String> getContent() {
        return content;
    }

    public void setContent(Map<String, String> content) {
        this.content = content;
    }
}
