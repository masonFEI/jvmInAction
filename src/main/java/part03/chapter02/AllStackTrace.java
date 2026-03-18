/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * AllStackTrace
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-18 22:10
 */
public class AllStackTrace {

    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> all = Thread.getAllStackTraces();
        Set<Map.Entry<Thread, StackTraceElement[]>> entries = all.entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> entry : entries) {
            Thread t = entry.getKey();
            StackTraceElement[] v = entry.getValue();
            System.out.println("[thread name is: " + t.getName() + "]");

            for (StackTraceElement stackTraceElement : v) {
                System.out.println("\t" + stackTraceElement.toString());
            }
        }

    }

}
