/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

import java.io.File;

/**
 * 对象的创建与访问指令
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-02 22:54
 */
public class NewTest {

    // 1.创建指令
    public void newInstance() {
        Object obj = new Object();
        File file = new File("atguigu.avi");
    }

    public void newArray() {
        int[] intArray = new int[10];
        Object[] objArray = new Object[10];
        int[][] mintArray = new int[10][10];
        String[][] strArray = new String[10][5];
    }

    public void sayHello() {
        System.out.println("Hello, World!");
    }

    //2. 字段访问指令
    public void setOrderId() {
        Order order = new Order();
        order.id = 1001;
        System.out.println(order.id);

        Order.name = "ORDER";
        System.out.println(Order.name);
    }

    // 3. 数组操作指令
    public void setArray() {
        int[] intArray = new int[10];
        intArray[3] = 20;
        System.out.println(intArray[1]);

        boolean[] arr = new boolean[10];
        arr[1] = true;
    }

    public void arrLength() {
        double[] arr = new double[10];
        System.out.println(arr.length);
    }

    public String checkCast(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else {
            return null;
        }
    }

}

class Order {
    int id;
    static String name;
}
