/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 方法调用与返回指令
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-05 22:30
 */
public class MethodInvokeReturnTest {

    // 方法调用指令：invokespecial：静态分派
    public void invoke1() {
        // 情况1：类实例构造器方法：<init>()
        Date date = new Date();

        Thread t1 = new Thread();

        // 情况2：父类的方法
        super.toString();

        // 情况3：私有方法
        methodPrivate();
    }

    private void methodPrivate() {

    }

    // 方法调用指令：invokestatic:静态分派
    public void invoke2() {
        methodStatic();
    }

    public static void methodStatic() {

    }

    // 方法调用指令：invokeinterface:静态分派
    public void invoke3() {
        Thread t1 = new Thread();
        ((Runnable) t1).run();

        Comparable<Integer> com = null;
        com.compareTo(123);
    }

    // 方法调用指令：invokevirtual:动态分派
    public void invoke4() {
        System.out.println("hello");

        Thread t1 = null;
        t1.run();
    }

}
