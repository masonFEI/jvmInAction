/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

/**
 * ClassCastTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-01 16:03
 */
public class ClassCastTest {


    // 宽化类型转换
    public void upCast() {
        int i = 10;
        long l = i;
        float f = i;
        double d = i;

        float f1 = l;
        double d1 = l;

        double d2 = f1;
    }

    public void upCast2(byte b) {
        int i = b;
        long l = b;
        double d = b;
    }


    // 窄化类型转换
    public void downCast() {
        int i = 10;
        byte b = (byte) i;
        short s = (short) i;
        char c = (char) i;

        long l = 10L;
        int i1 = (int) l;
        byte b1 = (byte) l;// 两个指令支持：l2i i2b
    }

    public void downCast3() {
        short s = 10;
        byte b = (byte) s;
    }

}
