/**
 * LY.com Inc.
 * Copyright (c) 2004-2025 All Rights Reserved.
 */
package part01.chapter16;

import java.lang.ref.WeakReference;

/**
 * 弱引用测试
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2025-12-30 16:01
 */
public class WeakReferenceTest {


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
        // 创建对象，建立弱引用
        WeakReference<WeakReferenceTest.User> userWeakRef = new WeakReference<>(new WeakReferenceTest.User(1, "songhongkang"));

        // 上面的一行代码，等价于如下的三行代码
        // User user = new User(1, "songhongkang");
        // WeakReference<User> userSoftRef = new WeakReference<>(user);
        // user = null; 取消强引用

        // 从弱引用中获取强引用对象
        System.out.println(userWeakRef.get());

        System.gc();
        System.out.println("After GC:");
        // 再次从软引用中获取强引用对象
        System.out.println(userWeakRef.get());

    }

}
