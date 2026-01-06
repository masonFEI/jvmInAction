package part01.chapter02;

public class StringTest {

    public static void main(String[] args) {
        String str = new java.lang.String();
        System.out.println("hello");

        StringTest stringTest = new StringTest();
        System.out.println(stringTest.getClass().getClassLoader());// sun.misc.Launcher$AppClassLoader@18b4aac2
    }

}
