package com.main.patterns.chainofresp;

public class DebugLogProcessor extends LogProcessor {


    public DebugLogProcessor(int level, LogProcessor nextLogProcessor) {
        super(level, nextLogProcessor);
    }

    @Override
    protected void write(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
