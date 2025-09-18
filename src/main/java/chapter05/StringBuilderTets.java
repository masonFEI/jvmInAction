package chapter05;

/**
 * 方法中定义的局部变量是否线程安全？具体情况具体分析
 * <p>
 * 何为线程安全？
 * 如果只有一个线程才可以操作此数据，则必是线程安全的。
 * 如果有多个线程操作此数据，则此数据是共享数据。如果不考虑同步机制的话，会存在线程安全问题。
 *
 * 局部变量在方法内部产生，方法内部消亡，是线程安全的；局部变量被方法返回出去的，是不安全的。
 */
public class StringBuilderTets {


    // s1的声明方式是线程安全的
    public static void method1() {
        // StringBuilder；线程不安全
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        // ...
    }


    // sBuilder的操作过程：是线程不安全的
    public static void method2(StringBuilder sBuilder) {
        sBuilder.append("a");
        sBuilder.append("b");
        // ...
    }

    // s1的操作，有可能是线程不安全的，因为有返回值
    public static StringBuilder method3() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        return s1;
    }


    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        method2(s);
    }

}
