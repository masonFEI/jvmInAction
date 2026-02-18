/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter03;

/**
 * StaticDeadLockMain
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-18 20:24
 */
class StaticA {
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Class.forName("part02.chapter03.StaticB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("StaticA init OK");
    }
}

class StaticB {
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Class.forName("part02.chapter03.StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("StaticB init OK");
    }
}


public class StaticDeadLockMain extends Thread {

    private char flag;

    public StaticDeadLockMain(char flag) {
        this.flag = flag;
        this.setName("Thread" + flag);
    }

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
     */
    @Override
    public void run() {
        try {
            Class.forName("part02.chapter03.Static" + flag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " over");
    }


    public static void main(String[] args) throws InterruptedException {
        StaticDeadLockMain loadA = new StaticDeadLockMain('A');
        loadA.start();

        StaticDeadLockMain loadB = new StaticDeadLockMain('B');
        loadB.start();
    }

}
