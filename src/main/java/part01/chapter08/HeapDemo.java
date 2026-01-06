package part01.chapter08;

/**
 * -Xms10m -Xmx10m
 */
public class HeapDemo {

    public static void main(String[] args) {

        System.out.println("start...");
        try {
            Thread.sleep(2000000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("end");

    }

}
