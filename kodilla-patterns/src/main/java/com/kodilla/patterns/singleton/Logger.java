package com.kodilla.patterns.singleton;

public class Logger {

    private static Logger loggerInstance = null;
    private Logger() {
    }
    public static Logger getInstance() {
        if (loggerInstance == null) {
            synchronized(Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                }
            }
        }
        return loggerInstance;
    }

    private String lastLog = "";

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }


}
