/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter04;

/**
 * ClassLoaderTest1
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-28 22:02
 */
public class ClassLoaderTest1 {

    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        // 视图获取引导类加载器：失败
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        try {
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            // 自定义的类，默认使用系统类加载器
            ClassLoader classLoader1 = Class.forName("part02.chapter04.ClassLoaderTest1").getClassLoader();
            System.out.println(classLoader1);

            int[] arr2 = new int[10];
            System.out.println(arr2.getClass().getClassLoader());//null,基本数据类型由虚拟机预先定义，不需要类的加载器

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
