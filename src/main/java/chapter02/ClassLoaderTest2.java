package chapter02;

public class ClassLoaderTest2 {

    public static void main(String[] args) {
        try {
            // 1.
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
            // 2.
            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);// sun.misc.Launcher$AppClassLoader@18b4aac2
            // 3.
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader2);// sun.misc.Launcher$ExtClassLoader@28d93b30
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
