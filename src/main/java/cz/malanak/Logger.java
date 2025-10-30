package cz.malanak;

import java.util.Date;

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
}
