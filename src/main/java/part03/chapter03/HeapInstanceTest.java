/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * HeapInstanceTest
 * 
 * -Xms600m -Xmx600m -XX:SurvivorRatio=8
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-19 09:07
 */
public class HeapInstanceTest {

    byte[] buffer = new byte[new Random().nextInt(1024 * 100)];

    public static void main(String[] args) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<HeapInstanceTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
