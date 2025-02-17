package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) {
        String now = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", now, Thread.currentThread().getName(), obj);
    }


}
