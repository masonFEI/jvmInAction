/**
 * LY.com Inc.
 * Copyright (c) 2004-2025 All Rights Reserved.
 */
package part01.chapter16;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用的测试
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2025-12-30 16:10
 */
public class PhantomReferenceTest {

    // 当前类对象的声明
    public static PhantomReferenceTest          obj;

    // 虚引用的引用队列
    static ReferenceQueue<PhantomReferenceTest> phantomQueue = null;

    public static class CheckRefQueue extends Thread {
        @Override
        public void run() {
            while (true) {
                if (phantomQueue != null) {
                    PhantomReference<PhantomReferenceTest> objt = null;
                    try {
                        // 从引用队列中取出虚引用对象
                        objt = (PhantomReference<PhantomReferenceTest>) phantomQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (objt != null) {
                        System.out.println("Object is deleted");
                    }
                }
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("PhantomReferenceTest finalize called");
        obj = this;
    }

    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);// 设置为守护线程，当程序中没有非守护线程时，守护线程会自动结束
        t.start();

        phantomQueue = new ReferenceQueue<>();
        obj = new PhantomReferenceTest();
        // 构造了 PhantomReferenceTest 对象的虚引用，并指定了引用队列
        PhantomReference<PhantomReferenceTest> phantomRef = new PhantomReference<>(obj, phantomQueue);

        try {
            // 不可获取虚引用的对象
            System.out.println(phantomRef.get());

            // 将强引用去除
            obj = null;
            // 第一次进行GC，由于对象可复活，GC无法回收该对象
            System.gc();
            Thread.sleep(1000);
            if (obj == null) {
                System.out.println("obj is null");
            } else {
                System.out.println("obj is not null");
            }

            System.out.println("第二次GC");
            obj = null;
            System.gc();// 一旦将obj对象回收，就会将此虚引用存放到引用队列中
            Thread.sleep(1000);
            if (obj == null) {
                System.out.println("obj is null");
            } else {
                System.out.println("obj is not null");
            }

        } catch (Exception e) {

        }

    }

}
