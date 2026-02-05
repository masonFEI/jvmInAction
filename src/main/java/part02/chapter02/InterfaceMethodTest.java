/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

/**
 * 补充：方法调用指令的补充说明
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-05 22:43
 */
public class InterfaceMethodTest {
    public static void main(String[] args) {
        AA aa = new BB();

        // invokeinterface
        aa.method2();

        // invokestatic
        AA.method1();
    }

}

interface AA {
    public static void method1() {

    }

    public default void method2() {

    }
}

class BB implements AA {

}