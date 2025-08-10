package chapter02;

import java.io.FileNotFoundException;

public class CustomClassLoader extends ClassLoader {


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
        try {
            // 以二进制字节流的形式读取到内存
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomPath(String name) {
        //从自定义路径中加载指定类：细节略
        // 如果指定路径的字节码文件进行了加密，则需要在此方法中进行解密操作
        return null;
    }


    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();

        try {
            Class<?> clazz = Class.forName("One", true, customClassLoader);
            Object o = clazz.newInstance();
            System.out.println(o.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
