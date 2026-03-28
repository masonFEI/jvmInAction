/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter03;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * MemoryLeak
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-28 22:31
 */
public class MemoryLeak {

    public static void main(String[] args) {
        while (true) {
            ArrayList beanList = new ArrayList<>();
            for (int i = 0; i < 500; i++) {
                Bean data = new Bean();
                data.list.add(new byte[1024 * 10]);// 10kb
                beanList.add(data);
            }

            try {
                TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class Bean {
    int              size = 10;
    String           info = "hello,atguigu";
    static ArrayList list = new ArrayList<>();
}
