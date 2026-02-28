/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter04;

import sun.misc.Launcher;

import java.net.URL;

/**
 * ClassLoaderTest
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-02-28 21:35
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println("--------------启动类加载器--------------");
        // 获取BootStrapClassLoader能够加载的api的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }

        System.out.println("--------------扩展类加载器--------------");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String extDir : extDirs.split(";")) {
            System.out.println(extDir);
        }
    }

}
