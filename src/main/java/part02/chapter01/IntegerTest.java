/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter01;

/**
 * IntegerTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-01-13 20:13
 */
public class IntegerTest {


    public static void main(String[] args) {
        Integer x = 5;
        int y = 5;

        System.out.println(x == y); // true

        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2); // true

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4); // false


    }


}
