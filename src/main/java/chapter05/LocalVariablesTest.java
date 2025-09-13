package chapter05;

import java.util.Date;

public class LocalVariablesTest {

    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    public static void testStatic() {
        // this不存在静态方法的局部变量表中
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
    }

    public void test1() {
        Date date = new Date();
        String name1 = "atguigu.com";
        test2(date, name1);
        System.out.println(date + name1);
    }

    public String test2(Date dateP, String name2) {
        dateP = new Date();
        name2 = "songhongkang";
        double weight = 130.5;// 占据两个slot
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
        // 变量c使用之前已经销毁的变量b占据的slot的位置
        int c = a + 1;
    }

    /**
     * 变量的分类:
     * 按照数据类型分：基本数据类型，引用数据类型
     * 按照类中声明的位置分：
     * 1.成员变量:在使用前，都经历过默认初始化赋值
     * 1.1.类变量（被static修饰，或者称为静态变量）：Linking的prepare阶段：给类变量默认赋值 --> initial阶段：给类变量显式赋值即静态代码块赋值
     * 1.2.实例变量（没有被static修饰）：随着对象的创建，会在堆空间中分配实例变量空间，并进行默认赋值
     * 2.局部变量：在使用前，必须要进行显式赋值！否则，编译不通过。
     *
     */
    public void test5() {
        int num;
//        System.out.println(num);// 错误信息：变量num未进行初始化
    }


}
