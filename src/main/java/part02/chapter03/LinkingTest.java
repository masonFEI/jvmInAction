/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

/**
 * LinkingTest
 * <p>
 * 基本数据类型：非final修饰的变量，在准备环节进行默认初始化赋值
 * final修饰以后，在准备环节直接进行显式赋值
 * <p>
 * 扩展；如果使用字面量的方式定义一个字符串的常量的话，也是在准备环节进行显式赋值。
 * 在这个阶段并不会像初始化阶段中那样会有初始化或者代码被执行。
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-15 10:08
 */
public class LinkingTest {


    private static long id;//

    private static final int num = 1;//

    public static final String constStr = "CONST";//

    public static final String constStr1 = new String("CONST");

}
