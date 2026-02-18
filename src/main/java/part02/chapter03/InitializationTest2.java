/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

import java.util.Random;

/**
 * 说明：使用static final修饰的字段的显式赋值的操作，到底是在哪个阶段进行的赋值？
 * 情况1：在链接阶段的准备环节赋值
 * 情况2：在初始化阶段<clinit>()中赋值
 * <p>
 * 结论：
 * 在链接阶段的准备环节赋值的情况：
 * 1. 对于基本数据类型的字段来说，如果使用static final修饰，则显式赋值(直接赋值常量，而非调用方法)通常是在链接阶段的准备环节赋值
 * 2. 对于String来说，如果使用字面量的方式赋值，使用static final修饰的话，则显式赋值通常是在链接阶段的准备环节进行赋值
 * <p>
 * <p>
 * 在初始化阶段<clinit>()中赋值的情况：
 * 排除上述的在准备环节赋值的情况之外的情况。
 * <p>
 * 最终结论：使用static + final修饰，且显式赋值中不涉及到方法或构造器调用的基本数据类型或String类型的显式赋值，是在在链接阶段的准备环节进行。
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-18 17:43
 */
public class InitializationTest2 {

    public static int a = 1;// 在初始化阶段<clinit>()中赋值
    public static final int INT_CONSTANT = 10;//在链接阶段的准备环节赋值

    public static final Integer INTEGER_CONSTANT1 = Integer.valueOf(100);// 在初始化阶段<clinit>()中赋值
    public static final Integer INTEGER_CONSTANT2 = Integer.valueOf(1000);// 在初始化阶段<clinit>()中赋值

    public static final String s0 = "helloworld0";//在链接阶段的准备环节赋值
    public static final String s1 = new String("helloworld");// 在初始化阶段<clinit>()中赋值

    public static String s2 = "helloworld2";

    public static final int NUM1 = 2;//在链接阶段的准备环节赋值
    public static final int NUM2 = new Random().nextInt(10);// 在初始化阶段<clinit>()中赋值

}
