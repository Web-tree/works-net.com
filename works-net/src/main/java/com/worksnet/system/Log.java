package com.worksnet.system;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 20:40
 */
public class Log {

    public static void log(String message) {

    }

    public static void log(String message, Throwable throwable) {
        System.out.println(message);
        throwable.printStackTrace();
    }
}
