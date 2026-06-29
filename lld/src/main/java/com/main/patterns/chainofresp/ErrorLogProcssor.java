package com.main.patterns.chainofresp;

public class ErrorLogProcssor extends LogProcessor {

    public ErrorLogProcssor(int level, LogProcessor nextLogProcessor) {
        super(level, nextLogProcessor);
    }

    @Override
    protected void write(String message) {
        System.out.println("ErrorLogProcssor: " + message);
    }
}
