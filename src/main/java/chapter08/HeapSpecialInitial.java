package chapter08;


/**
 * -Xms 用来设置堆空间(年轻代+老年代)的初始内存大小
 * -X 是jvm的运行蚕食
 * ms 是 memory start
 * -Xmx 用来设置堆空间(年轻代+老年代)的最大内存大小
 * -X 是jvm的运行蚕食
 * mx 是 memory max
 */
public class HeapSpecialInitial {

    public static void main(String[] args) {
        // 返回java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // 返回java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms: " + initialMemory + "M");
        System.out.println("-Xmx: " + maxMemory + "M");

        System.out.println("系统内存大小为: " + initialMemory * 64.0 / 1024 + "G");
        System.out.println("系统内存大小为: " + maxMemory * 4.0 / 1024 + "G");
    }

}
