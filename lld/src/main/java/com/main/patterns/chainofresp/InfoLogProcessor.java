package com.main.patterns.chainofresp;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(int level, LogProcessor nextLogProcessor) {
        super(level, nextLogProcessor);
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}
