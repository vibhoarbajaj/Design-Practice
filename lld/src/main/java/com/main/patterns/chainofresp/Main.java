package com.main.patterns.chainofresp;

public class Main {
    public static void main(String[] args) {
        LogProcessor errorLog = new ErrorLogProcssor(LogProcessor.ERROR , null);
        LogProcessor debugLog = new DebugLogProcessor(LogProcessor.DEBUG , errorLog);
        LogProcessor infoLog = new InfoLogProcessor(LogProcessor.INFO , debugLog);
        //todo info -> debug->error
        infoLog.logMessage(4,"hello world");

    }
}
