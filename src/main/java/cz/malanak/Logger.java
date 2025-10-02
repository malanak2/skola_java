package cz.malanak;

import java.util.Date;

public class Logger {
    private static void log(String prefix, String message) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        System.out.println(String.format("[%s][%s][%s]: %s",new Date().toString(), prefix, caller.toString(), message));
    }

    public static void warn(String message) {
        log("\u001B[33mWARN\u001B[0m", message);
    }
    public static void info(String message) {
        log("INFO", message);
    }
    public static void error(String message) {
        log("\u001B[31mERROR\u001B[0m", message);
    }
}
