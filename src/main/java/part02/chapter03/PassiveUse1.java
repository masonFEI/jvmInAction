/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

import org.junit.Test;

/**
 * 关于类的被动使用，即不会进行类的初始化操作，即不会调用<clinit>()
 * 1.当访问一个静态字段时，只要真正声明这个字段的类才会被初始化。
 * > 当通过子类引用父类的静态变量，不会导致子类初始化。
 * 说明：没有初始化的类，不意味着没有加载！
 * <p>
 * 2.通过数组定义类引用，不会导致类的初始化。
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-20 09:11
 */
public class PassiveUse1 {

    @Test
    public void test1() {
        System.out.println(Child.num);
    }

    @Test
    public void test2() {
        Parent[] parents = new Parent[10];
        System.out.println(parents.getClass());
        System.out.println(parents.getClass().getSuperclass());

        parents[0] = new Parent();
        parents[1] = new Parent();
    }

}

class Parent {
    static {
        System.out.println("parent的初始化过程");
    }

    public static int num = 1;
}

class Child extends Parent {
    static {
        System.out.println("child的初始化过程");
    }


}

