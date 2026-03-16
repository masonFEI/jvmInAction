/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * GCTest
 *
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-16 22:22
 */
public class GCTest {

    public static void main(String[] args) {

        List<byte[]> list = new ArrayList<byte[]>();

        for (int i = 0; i < 1000; i++) {
            byte[] arr = new byte[1024 * 100];// 100kb
            list.add(arr);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
