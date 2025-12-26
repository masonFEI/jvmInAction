package chapter09;

/**
 * 测试设置方法区大小参数的默认值
 *
 * jdk8及以后
 * -XX:MetaspaceSize=100m -XX:MaxMetaspaceSize=100m
 */
public class MethodAreaDemo {

    public static void main(String[] args) {
        System.out.println("start...");

        try {
            Thread.sleep(2000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
