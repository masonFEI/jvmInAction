package chapter02;

import sun.misc.Launcher;
import sun.security.ec.ECKeyFactory;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {


    public static void main(String[] args) {
        System.out.println("*********************启动类加载器*************");
        // 获取BootstrapClassLoader能够加载的api的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();

        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }

        // 从上面的路径中随意选择一个类，来看看它的类加载器是什么:引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);//null
        System.out.println("*********************扩展类加载器*************");
        String extDirs = System.getProperty("java.ext.dirs");
        String separator = System.getProperty("path.separator"); // 获取系统路径分隔符
        for (String extDir : extDirs.split(separator)) {
            System.out.println(extDir);
        }

        // 从上面的路径中随意选择一个类，来看看它的类加载器是什么:扩展类加载器
        ClassLoader classLoader1 = ECKeyFactory.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@28d93b30


    }


}
