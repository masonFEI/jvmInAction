/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

import java.util.Random;

/**
 * 3.当使用类、接口的静态字段时（final修饰特殊考虑），比如，使用getstatic或者putstatic指令时。（对应访问变量，赋值变量操作）
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-19 10:30
 */
public class ActiveUse2 {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
//        System.out.println(User.num1);
        System.out.println(User.num2);
    }

    public static void test2() {
        System.out.println(CompareA.NUM2);
    }

}

class User {
    static {
        System.out.println("User类的初始化过程");
    }

    public static int num = 1;
    public static final int num1 = 1;
    public static final int num2 = new Random().nextInt(10);
}

interface CompareA {

    public static final Thread t = new Thread() {
        {
            System.out.println("CompareA接口的初始化过程");
        }
    };

    public static final int NUM1 = 1;
    public static final int NUM2 = new Random().nextInt(10);
}
