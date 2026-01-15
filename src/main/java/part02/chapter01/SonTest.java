/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter01;

/**
 * SonTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-01-15 20:55
 */

class Father {
    int x = 10;

    public Father() {
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("Father.x=" + x);
    }

}

class Son extends Father {
    int x = 30;

    public Son() {
        this.print();
        x = 40;
    }

    @Override
    public void print() {
        System.out.println("Son.x=" + x);
    }
}


public class SonTest {

    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.x);
    }

}
