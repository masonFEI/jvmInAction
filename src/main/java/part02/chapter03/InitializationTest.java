/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

/**
 * InitiallizationTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-15 12:25
 */
public class InitializationTest {

    public static int id = 1;
    public static int number;

    static {
        number = 2;
        System.out.println("father static");
    }


}
