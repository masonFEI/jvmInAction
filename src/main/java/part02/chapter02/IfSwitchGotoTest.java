/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

/**
 * 控制转移指令
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-08 15:18
 */
public class IfSwitchGotoTest {

    // 1.条件跳转指令
    public void compare1() {
        int a = 0;
        if (a == 0) {
            a = 10;
        } else {
            a = 20;
        }
    }

    public boolean compareNull(String str) {
        if (str == null) {
            return true;
        }
        return false;
    }

    // 结合比较指令
    public void compare2() {
        float f1 = 9;
        float f2 = 10;
        System.out.println(f1 < f2);
    }

    public void compare3() {
        int i1 = 10;
        int l1 = 20;
        System.out.println(i1 < l1);
    }

    // 2.比较条件跳转指令
    public void ifCompare1() {
        int i = 10;
        int j = 10;
        System.out.println(i < j);
    }

    public void ifCompare2() {
        short s1 = 9;
        byte b1 = 10;
        System.out.println(s1 > b1);
    }

    public void ifCompare3() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1 == obj2);
        System.out.println(obj1 != obj2);
    }

}
