package part01.chapter02;

public class ClinitTest1 {

    static class Father {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        // 初始化Father类，其次初始化Son类
        System.out.println(Son.B);// 2
    }

}
