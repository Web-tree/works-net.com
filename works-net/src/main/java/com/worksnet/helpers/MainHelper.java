package com.worksnet.helpers;

import java.io.InputStream;

/**
 * @author Max Levicky
 *         Date: 25.02.13
 *         Time: 23:41
 */
public class MainHelper {
    public static String getPath() {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml");
        return resourceAsStream.toString();
    }
}
