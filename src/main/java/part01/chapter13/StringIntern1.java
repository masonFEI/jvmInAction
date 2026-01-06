package part01.chapter13;

public class StringIntern1 {

    public static void main(String[] args) {
        //  StringIntern.java的扩展
        String s3 = new String("1") + new String("1");
        String s4 = "11";// 在字符串常量池中生成对象“11”
        s3.intern();// 常量池中已存在“11”,相当于什么都没做
        String s5 = s3.intern();// 返回常量池中对象的引用地址

        System.out.println(s3 == s4);// false
        System.out.println(s5 == s4);// true
    }

}
