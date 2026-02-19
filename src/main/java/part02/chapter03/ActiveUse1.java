/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

import java.io.*;
import java.util.Objects;

/**
 * 测试类的主动使用：意味着会调用类的<clinit>(),即执行了类的初始化
 * <p>
 * 1.当创建一个类的实例时，比如使用new关键字，或者通过反射、克隆、反序列化
 * 2.当调用类的静态方法时，即当使用了字节码invokestatic指令时
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-18 21:49
 */
public class ActiveUse1 {

    public static void main(String[] args) {
        test3();
    }

    // 序列化的过程：
    public static void test1() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("order.dat"));
            oos.writeObject(new Order());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(oos)) {
                    oos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 反序列化的过程：（验证）
    public static void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("order.dat"));
            Order order = (Order) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(ois)) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void test3() {
        Order.method();
    }

}

class Order implements Serializable {
    static {
        System.out.println("Order类的初始化过程");
    }

    public static void method() {
        System.out.println("Order method");
    }
}
