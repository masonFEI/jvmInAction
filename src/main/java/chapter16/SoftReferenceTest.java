/**
 * LY.com Inc.
 * Copyright (c) 2004-2025 All Rights Reserved.
 */
package chapter16;

import java.lang.ref.SoftReference;

/**
 * 软引用测试
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2025-12-30 14:51
 */
public class SoftReferenceTest {

    public static class User {
        public int    id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return " User{id=" + id + ", name='" + name + '\'' + '}';
        }

    }

    public static void main(String[] args) {
        // 创建对象，建立软引用
        SoftReference<User> userSoftRef = new SoftReference<>(new User(1, "songhongkang"));

        // 上面的一行代码，等价于如下的三行代码
        // User user = new User(1, "songhongkang");
        // SoftReference<User> userSoftRef = new SoftReference<>(user);
        // user = null; 取消强引用

        // 从软引用中获取强引用对象
        System.out.println(userSoftRef.get());

        System.gc();
        System.out.println("After GC:");
        // 再次从软引用中获取强引用对象
        System.out.println(userSoftRef.get());// 由于堆空间足够，垃圾收集器不会回收软引用对象

        try {
            // 分配大块内存，制造内存紧张
            byte[] b = new byte[1024 * 7168 - 732 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("After allocating large memory:");
            // 再次从软引用中获取强引用对象
            System.out.println(userSoftRef.get());// 在报OOM之前，垃圾回收器会收集软引用的可达对象
        }

    }

}
