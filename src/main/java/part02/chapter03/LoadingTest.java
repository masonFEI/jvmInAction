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
            Method[] ms = clazz.getDeclaredMethods();
            for (Method m : ms) {
                String mod = Modifier.toString(m.getModifiers());
                System.out.println(mod + " ");
                String returnType = m.getReturnType().getSimpleName();
                System.out.println(returnType + " ");
                System.out.println(m.getName() + "(");
                Class<?>[] ps = m.getParameterTypes();
                if (ps.length == 0) {
                    System.out.println(")");
                }

                for (int i = 0; i < ps.length; i++) {
                    char end = (i == ps.length - 1) ? ')' : ',';
                    System.out.println(ps[i].getSimpleName()+end);
                }
                System.out.println();
            }
        } catch (Exception e) {

        }
    }

}
