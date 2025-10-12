/**
 * LY.com Inc.
 * Copyright (c) 2004-2025 All Rights Reserved.
 */
package chapter08;

/**
 * EdenSurvivorTest
 *
 * -Xms600m -Xmx600m
 *
 * -NewRatio: 设置新生代与老年代的比例，默认值为2
 *
 * -XX:SurvivorRatio: 设置新生代中Edan区与Survivor区的比例
 *
 * -XX:-UseAdaptiveSizePolicy 关闭自适应的内存分配策略
 * -XX:+UseAdaptiveSizePolicy 开启自适应的内存分配策略，默认
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2025-10-08 18:47
 */
public class EdenSurvivorTest {


    public static void main(String[] args) {
        System.out.println("我只是来打个酱油");
        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}