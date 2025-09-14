package chapter05;


/**
 * 体会invokedynamic
 */
//函数式接口
interface Func {
    public boolean func(String str);
}

public class Lambda {

    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();

        // invokedynamic,由变量值确定类型信息，使得java有了一定程度的动态类型
        Func func = s -> {
            return true;
        };

        lambda.lambda(func);
        lambda.lambda(s -> {
            return true;
        });

    }


}
