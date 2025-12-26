package chapter09;

/**
 *  静态引用对应的对象实例始终都存在堆空间
 *
 * jdk 8:
 * -Xms200m -Xmx200m -XX:MetaspaceSize=300m -XX:MaxMetaspaceSize=300m -XX:+PrintGCDetails
 */
public class StaticFieldTest {

    private static final byte[] arr = new byte[1024 * 1024 * 100];// 100mb

    public static void main(String[] args) {
        System.out.println(StaticFieldTest.arr);
        // try {
        // Thread.sleep(1000000);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }

}
