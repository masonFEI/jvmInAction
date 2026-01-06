package part01.chapter15;

/**
 * 引用计数法的垃圾回收算法测试
 */
public class RefCountGC {

    Object reference = null;

    public static void main(String[] args) {

        RefCountGC obj1 = new RefCountGC();
        RefCountGC obj2 = new RefCountGC();

        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1 = null;
        obj2 = null;

        System.gc();

        try {
            Thread.sleep(1000000);
        } catch (Exception e) {

        }

    }

}
