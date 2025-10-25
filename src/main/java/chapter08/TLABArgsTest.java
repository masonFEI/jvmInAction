package chapter08;

public class TLABArgsTest {


    /**
     *
     * 测试-XX:UseTLAB参数是否开启的情况
     *
     * jinfo -flag UseTLAB pid 查看线程的TLAB是否开启
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("我只是来打个酱油~");
        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
