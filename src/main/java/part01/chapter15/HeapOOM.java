package part01.chapter15;

import java.util.ArrayList;

/**
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    byte[] buffer = new byte[1 * 1024 * 1024];// 1MB

    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new HeapOOM());
                count++;
            }
        } catch (Exception e) {
            System.out.println("count = " + count);
            e.printStackTrace();
        }

    }

}
