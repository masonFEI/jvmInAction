/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * LoadingTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-14 23:35
 */
public class LoadingTest {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            // 获取当前运行时类声明的所有方法
            Method[] ms = clazz.getDeclaredMethods();
            for (Method m : ms) {
                // 获取方法的修饰符
                String mod = Modifier.toString(m.getModifiers());
                System.out.println(mod + " ");
                // 获取方法的返回值类型
                String returnType = m.getReturnType().getSimpleName();
                System.out.println(returnType + " ");
                // 获取方法名称
                System.out.println(m.getName() + "(");
                // 获取方法的参数列表
                Class<?>[] ps = m.getParameterTypes();
                if (ps.length == 0) {
                    System.out.println(")");
                }

                for (int i = 0; i < ps.length; i++) {
                    char end = (i == ps.length - 1) ? ')' : ',';
                    // 获取参数的类型
                    System.out.println(ps[i].getSimpleName() + end);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
