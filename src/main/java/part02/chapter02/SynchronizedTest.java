/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

/**
 * SynchronizedTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-13 20:08
 */
public class SynchronizedTest {

    private int i = 0;

    public synchronized void add() {
        i++;
    }

    private Object obj = new Object();

    public void subtract() {
        synchronized (obj) {
            i--;
        }
    }


}
