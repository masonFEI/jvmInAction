/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part02.chapter04;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * MyClassLoader
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-02 22:51
 */
public class MyClassLoader extends ClassLoader {

    private String byteCodePath;

    /**
     * Creates a new class loader using the <tt>ClassLoader</tt> returned by
     * the method {@link #getSystemClassLoader()
     * <tt>getSystemClassLoader()</tt>} as the parent class loader.
     *
     * <p> If there is a security manager, its {@link
     * SecurityManager#checkCreateClassLoader()
     * <tt>checkCreateClassLoader</tt>} method is invoked.  This may result in
     * a security exception.  </p>
     *
     * @throws SecurityException If a security manager exists and its
     *                           <tt>checkCreateClassLoader</tt> method doesn't allow creation
     *                           of a new class loader.
     */
    public MyClassLoader(String byteCodePath) {
        this.byteCodePath = byteCodePath;
    }

    public MyClassLoader(ClassLoader parent, String byteCodePath) {
        super(parent);
        this.byteCodePath = byteCodePath;

    }

    /**
     * Finds the class with the specified <a href="#name">binary name</a>.
     * This method should be overridden by class loader implementations that
     * follow the delegation model for loading classes, and will be invoked by
     * the {@link #loadClass <tt>loadClass</tt>} method after checking the
     * parent class loader for the requested class.  The default implementation
     * throws a <tt>ClassNotFoundException</tt>.
     *
     * @param name The <a href="#name">binary name</a> of the class
     * @return The resulting <tt>Class</tt> object
     * @throws ClassNotFoundException If the class could not be found
     * @since 1.2
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            // 获取字节码文件的完整路径
            String fileName = byteCodePath + name + ".class";
            // 获取一个输入流
            bis = new BufferedInputStream(new FileInputStream(fileName));
            // 获取一个输出流
            baos = new ByteArrayOutputStream();
            // 具体读取字节码文件，并将其写入到输出流中
            int len;
            byte[] data = new byte[1024];
            while ((len = bis.read(data)) != -1) {
                baos.write(data, 0, len);
            }
            // 获取内存中的完整的字节数组的数据
            byte[] classData = baos.toByteArray();
            // 调用defineClass方法将字节数组的数据转换成一个Class对象
            Class clazz = defineClass(name, classData, 0, classData.length);
            return clazz;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
