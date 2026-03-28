/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter03;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * JProfilerTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-28 22:24
 */
public class JProfilerTest {

    public static void main(String[] args) {
        while (true) {
            ArrayList list = new ArrayList();
            for (int i = 0; i < 500; i++) {
                list.add(new Data());
            }

            try {
                TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Data {
    private int    size   = 10;
    private byte[] buffer = new byte[1024 * 1024];
    private String info   = "hello,atguigu";
}
