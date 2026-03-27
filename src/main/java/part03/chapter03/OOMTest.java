/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter03;

import java.util.ArrayList;
import java.util.Random;

/**
 * OOMTest
 *
 * -Xms600m -Xmx600m -XX:SurvivorRatio=8
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-20 22:44
 */
public class OOMTest {

    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<Picture>();
        while (true) {
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(100 * 50)));
        }
    }

}

class Picture {
    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}
