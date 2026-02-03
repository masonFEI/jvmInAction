/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

import org.junit.Test;

/**
 * 算数指令Test
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-01 14:59
 */
public class ArithmeticTest {

    public void method1() {
        int i = 10;
        double j = i / 0.0;
        System.out.println(j);// 无穷大

        double d1 = 0.0;
        double d2 = d1 / 0.0;
        System.out.println(d2);// NaN:not a number
    }

    public void method2() {
        float i = 10;
        float j = -i;
        i = -j;
    }

    public void method3(int j) {
        int i = 100;
        // i = i + 10;

        i += 10;
    }

    public int method4() {
        int a = 80;
        int b = 7;
        int c = 10;
        return (a + b) * c;
    }

    public int method5(int i, int j) {
        return ((i + j - 1) & ~(j - 1));
    }

    // 关于（前）++和（后）++的区别
    public void method6() {
        int i = 10;
        i++;
        // ++i;
    }

    public void method7() {
        int i = 10;
        int a = i++;
        int j = 20;
        int b = ++j;
    }

    public void nethod8() {
        int i = 10;
        i = i++;
        System.out.println(i);// 10
    }

}
