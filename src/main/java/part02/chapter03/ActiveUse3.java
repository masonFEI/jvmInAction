/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

import org.junit.Test;

import java.util.Random;

/**
 * 4.当使用java.lang.reflect包中的方法反射类的方法时。比如：Class.forName("com.ly.reflect.Person")
 * 5.当初始化子类时，如果父类没有被初始化，则先初始化父类
 * 补充说明：
 * 当java虚拟机初始化一个类时，要求它的所有父类都已经被初始化。但是这条规则并不适用于接口。
 * >当初始化一个类时，并不会先初始化它所实现的接口。
 * >当初始化一个接口时，并不会先初始化它的父接口。
 * <p>
 * 6.当通过子接口调用父接口中定义的 default 方法时（且该方法没被子接口重写），会触发父接口的初始化
 * <p>
 * 7.当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
 * <p>
 * 8.当初次调用 MethodHandle实例的invoke()或者invokeExact()方法时，如果MethodHandle指向的类还没有被初始化，则先初始化这个类。
 * (涉及解析REF_getStatic、REF_putStatic、REF_invokeStatic方法句柄对应的类)
 * <p>
 * -XX:+TraceClassLoading 跟踪类的加载过程
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-19 10:53
 */
public class ActiveUse3 {

    static {
        System.out.println("ActiveUse3类的初始化过程");
    }

    @Test
    public void test1() {
        try {
            Class clazz = Class.forName("part02.chapter03.Order");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        System.out.println(Son.num);
    }

    @Test
    public void test3() {
        System.out.println(CompareC.NUM1);
    }

    @Test
    public void test4() {
        System.out.println(Son.num);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}

class Father {
    static {
        System.out.println("Father类的初始化过程");
    }
}

class Son extends Father implements CompareB {
    static {
        System.out.println("Son类的初始化过程");
    }

    public static int num = 1;
}

interface CompareB {
    public static final Thread t = new Thread() {
        {
            System.out.println("CompareB接口的初始化过程");
        }
    };

    public static final int NUM1 = 1;
    public static final int NUM2 = new Random().nextInt(10);

    public default void method1() {
        System.out.println("hello");
    }
}

interface CompareC extends CompareB {
    public static final Thread t = new Thread() {
        {
            System.out.println("CompareC接口的初始化过程");
        }
    };
    public static final int NUM1 = new Random().nextInt(10);
}
