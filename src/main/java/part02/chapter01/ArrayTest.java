/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter01;

/**
 * ArrayTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-01-19 19:56
 */
public class ArrayTest {

    public static void main(String[] args) {
        Object[] arr = new Object[10];
        System.out.println(arr);//[Ljava.lang.Object;  描述符+全限定名

        String arr1[] = new String[10];
        System.out.println(arr1);//[Ljava.lang.String

        long[][] arr2 = new long[5][5];
        System.out.println(arr2);
    }

}
