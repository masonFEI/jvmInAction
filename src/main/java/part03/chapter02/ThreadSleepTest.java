/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter02;

/**
 * ThreadSleepTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-18 22:04
 */
public class ThreadSleepTest {

    public static void main(String[] args) {
        System.out.println("hello - 1");

        try {
            Thread.sleep(2000 * 60 * 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("hello - 2");
    }

}
