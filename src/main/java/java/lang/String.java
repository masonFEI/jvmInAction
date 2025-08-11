package java.lang;

public class String {

    static {
        System.out.println("hello,我是自定义的String的静态代码块");
    }

    // 错误，在java.lang.String类中没有main方法
    public static void main(String[] args) {
        System.out.println("hello,string");
    }


}
