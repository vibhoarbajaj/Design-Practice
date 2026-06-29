package com.main.patterns.chainofresp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class LogProcessor {
    public static final int DEBUG = 2;
    public static final int INFO = 1;
    public static final int WARNING = 3;
    public static final int ERROR = 4;
    int level;

    private final LogProcessor nextLogProcessor;

    public void logMessage(int level, String message) {
        if (this.level == level) {
            write(message);
        }
        if (this.nextLogProcessor != null) {
            this.nextLogProcessor.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
