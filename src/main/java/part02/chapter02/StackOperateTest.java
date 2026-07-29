/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

/**
 * 操作数栈管理指令
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-07 23:30
 */
public class StackOperateTest {

    public void print() {
        Object obj = new Object();
        // String info = obj.toString();
        obj.toString();
    }

    public void foo() {
        bar();
    }

    public long bar() {
        return 0;
    }

    public long nextIndex() {
        return index++;
    }

    private long index = 0;

}
