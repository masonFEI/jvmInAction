/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

import org.junit.Test;

import java.util.Random;

/**
 * 3.引用常量不会导致类或接口的初始化。因为常量在链接阶段就已经被显式赋值了。
 * 4. 调用ClassLoader类的loadClass()方法加载一个类，并不是对类的主动使用，并不会导致这个类的初始化。
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-20 09:37
 */
public class PassiveUse2 {

    @Test
    public void test1() {
//        System.out.println(Person.NUM);
        System.out.println(Person.NUM1);
    }

    @Test
    public void test2() {
//        System.out.println(SerialA.ID);
        System.out.println(SerialA.ID1);
    }

    @Test
    public void test3() {
        try {
            ClassLoader.getSystemClassLoader().loadClass("part02.chapter03.Person");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

class Person {
    static {
        System.out.println("person类的初始化过程");
    }

    public static final int NUM = 1;// 在链接过程的准备环节就被赋值为1了
    public static final int NUM1 = new Random().nextInt(10);// 在链接过程的准备环节就被赋值为1了
}

interface SerialA {
    public static final Thread t = new Thread() {
        {
            System.out.println("SerialA接口的初始化过程");
        }
    };

    int ID = 1;
    int ID1 = new Random().nextInt(10);// 此时的赋值操作需要在<clinit>()方法中进行，所以会导致SerialA接口的初始化
}
