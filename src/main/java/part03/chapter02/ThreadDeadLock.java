/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter02;

/**
 * ThreadDeadLock
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-18 21:55
 */
public class ThreadDeadLock {

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        new Thread() {
            /**
             * If this thread was constructed using a separate
             * <code>Runnable</code> run object, then that
             * <code>Runnable</code> object's <code>run</code> method is called;
             * otherwise, this method does nothing and returns.
             * <p>
             * Subclasses of <code>Thread</code> should override this method.
             *
             * @see #start()
             * @see #stop()
             * @see #Thread(ThreadGroup, Runnable, String)
             */
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread() {
            /**
             * If this thread was constructed using a separate
             * <code>Runnable</code> run object, then that
             * <code>Runnable</code> object's <code>run</code> method is called;
             * otherwise, this method does nothing and returns.
             * <p>
             * Subclasses of <code>Thread</code> should override this method.
             *
             * @see #start()
             * @see #stop()
             * @see #Thread(ThreadGroup, Runnable, String)
             */
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("a22");
                    s2.append("122");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s1.append("b11");
                        s2.append("211");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();
    }

}
