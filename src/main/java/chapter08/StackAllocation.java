package chapter08;


/**
 * 栈上分配测试
 */
public class StackAllocation {


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start) + "ms");
        // 为了方便查看堆内存中对象个数，现成sleep
        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private static void alloc() {
        User user = new User();//未发生逃逸
    }


    static class User {

    }


}
