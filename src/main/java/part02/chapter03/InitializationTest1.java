/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

/**
 * InitializationTest1
 * <p>
 * 哪些场景下；java编译器就不会生成<clinit>()方法
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-18 17:33
 */
public class InitializationTest1 {
    // 场景1：对于非静态的字段，不管是否进行了显式赋值，都不会生成<clinit>()方法
    public int num = 1;

    // 场景2：静态的字段，没有显式的赋值，也不会生成<clinit>()方法
    public static int num1;

    // 场景3：比如对于声明为static final的基本数据类型的字段，不管是否进行了显式赋值，都不会生成<clinit>()方法
    public static final int num2 = 1;


}
