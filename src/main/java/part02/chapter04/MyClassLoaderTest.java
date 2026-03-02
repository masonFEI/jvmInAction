/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter04;

/**
 * MyClassLoaderTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-02 22:51
 */
public class MyClassLoaderTest {

    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader("D:/temp/classloader/");
        try {
            Class clazz = loader.loadClass("Demo1");

            System.out.println("加载此类的加载器为：{}" + clazz.getClassLoader().getClass().getName());

            System.out.println("加载当前demo1类的父加载器为：{}" + clazz.getClassLoader().getParent().getClass().getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
