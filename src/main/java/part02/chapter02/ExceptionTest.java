/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter02;

import java.io.IOException;

/**
 * ExceptionTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-13 17:21
 */
public class ExceptionTest {

    public void throwZero(int i) {
        if (i == 0) {
            throw new RuntimeException("参数值为0");
        }
    }


    public void throwOne(int i) throws RuntimeException, IOException {
        if (i == 1) {
            throw new RuntimeException("参数值为1");
        }
    }

    public void throwArithmetic() {
        int i = 10;
        int j = i / 0;

        System.out.println(j);
    }


}
