package chapter13;

public class StringIntern {


    public static void main(String[] args) {
        String s = new String("1");
        s.intern();//调用此方法之前，字符串常量池中已经存在了“1”
        String s2 = "1";
        System.out.println(s == s2);// false

        String s3 = new String("1") + new String("1");// s3变量记录的地址为：new String("11")
        //执行完上一行代码以后，字符串常量池中，是否存在“11”？不存在
        s3.intern();//在字符串常量池中生成“11”
        String s4 = "11";//s4变量记录的地址：使用的是上一行代码执行时，在常量池中生成的“11”的地址
        System.out.println(s3 == s4);// true


    }


}
