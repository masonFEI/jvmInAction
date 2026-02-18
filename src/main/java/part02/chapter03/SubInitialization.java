/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

/**
 * SubInitialization
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-18 17:18
 */
public class SubInitialization extends InitializationTest {

    static {
        number = 4;// number属性必须提前已经加载，一定会先加载父类
        System.out.println("son static()");
    }

    public static void main(String[] args) {
        System.out.println(number);
    }


}
