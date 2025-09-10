package chapter05;


/**
 * 说明早期绑定和晚期绑定的例子
 */
class Animal {
    public void eat() {
        System.out.println("动物进食");
    }

}

interface Huntable {
    void hunt();
}

class Dog extends Animal implements Huntable {
    @Override
    public void eat() {
        System.out.println("够吃骨头");
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子，多管闲事");
    }
}


public class Animaltest {
}
