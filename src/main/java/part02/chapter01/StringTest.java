/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter01;

/**
 * StringTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-01-14 22:52
 */
public class StringTest {

    public static void main(String[] args) {
        String str = new String("hello") + new String("world");
        String str1 = "helloworld";
        System.out.println(str == str1); // false
    }

}
