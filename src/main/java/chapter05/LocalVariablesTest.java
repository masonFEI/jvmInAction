package chapter05;

import java.util.Date;

public class LocalVariablesTest {

    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    public static void testStatic(){
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
    }



    public void test1() {
        Date date = new Date();
        String name1 = "atguigu.com";
    }

    public String test2(Date dateP, String name2) {
        dateP = new Date();
        name2 = "songhongkang";
        double weight = 130.5;
        char gender = '男';
        return dateP + name2;
    }

    public void test3() {
        count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        int c = a + 1;
    }


}
