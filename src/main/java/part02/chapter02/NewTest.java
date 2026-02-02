/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

import java.io.File;

/**
 * NewTest
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

}
