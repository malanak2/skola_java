package cz.malanak;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class Logger {
    private void log(String prefix, String message) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        System.out.println(String.format("[%s][%s][%s]: %s",new Date().toString(), prefix, caller.toString(), message));
    }

    public void warn(String message) {
        log("\u001B[33mWARN\u001B[0m", message);
    }
    public void info(String message) {
        log("INFO", message);
    }
    public void debug(String message) {
        if (Global.DEBUG) {
            log("\u001B[32mDEBUG\u001B[0m", message);
        }
    }
    public void error(String message) {
        log("\u001B[31mERROR\u001B[0m", message);
    }
    private void log(String prefix, String message, java.util.logging.Logger logger) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        logger.log(new LogRecord(Level.ALL, String.format("[%s][%s][%s]: %s",new Date().toString(), prefix, caller.toString(), message)));
    }
    public void warn(String message, java.util.logging.Logger logger) {
        log("\u001B[33mWARN\u001B[0m", message, logger);
    }
    public void info(String message, java.util.logging.Logger logger) {
        log("INFO", message, logger);
    }
    public void debug(String message, java.util.logging.Logger logger) {
        if (Global.DEBUG) {
            log("\u001B[32mDEBUG\u001B[0m", message, logger);
        }
    }
}
