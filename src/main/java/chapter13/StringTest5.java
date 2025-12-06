package chapter13;

public class StringTest5 {


    public static void main(String[] args) {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        // 如果拼接符号的前后出现了变量，则相当于在堆空间中 new String(),具体的内容为拼接的结果：javaEEhadoop
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;

        /**
         * s1 + s2的执行细节：(变量s是我临时定义的)
         * 1.StringBuilder s = new StringBuilder();
         * 2. s.append(s1);
         * 3. s.append(s2);
         * 4. s.toString(); -> 约等于 new String(“javaEEhadoop”);
         *
         * 补充：在jdk5.0之后使用的是StringBuilder，在jdk5.0之前使用的是StringBuffer
         */
        String s7 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);

        // intern():判断字符串常量池中是否存在javaEEhadoop，如果存在，则返回常量池中javaEEhadoop的地址
        // 如果字符串常量池中不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，并返回此对象的地址
        String s8 = s6.intern();
        System.out.println(s3 == s8);
    }


    /**
     * 1.字符串拼接操作不一定使用的是StringBuilder
     *    如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder的方式。
     * 2.针对于final修饰类，方法，基本数据类型，引用数据类型·的量的结构时，能使用上final的时候建议使用上。
     */
    public void test4(){
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1+s2;
        System.out.println(s3 == s4);
    }


}
