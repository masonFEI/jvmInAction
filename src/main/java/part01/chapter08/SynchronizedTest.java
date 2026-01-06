package part01.chapter08;

public class SynchronizedTest {


    public void f() {
        Object hollis = new Object();

        synchronized (hollis) {
            System.out.println(hollis);
        }
    }

}
