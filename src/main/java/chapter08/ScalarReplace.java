package chapter08;

/**
 * 标量替换测试
 * -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:PrintGC -XX:-EliminateAllocations
 */
public class ScalarReplace {

    public static class User {
        public String name;
        public int id;
    }

    public static void alloc() {
        User user = new User();// 未发生逃逸
        user.id = 5;
        user.name = "www.atguigu.com";
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + " ms");
    }


}
