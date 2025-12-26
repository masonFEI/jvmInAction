package chapter05.java3;

interface FriendLy {

    void sayHello();

    void sayGoodbye();
}

class Dog {

    public void sayHello() {

    }

    @Override
    public String toString() {
        return "Dog";
    }
}

class Cat implements FriendLy {

    public void eat() {

    }

    @Override
    public void sayHello() {

    }

    @Override
    public void sayGoodbye() {

    }

    protected void finalize() {

    }

    @Override
    public String toString() {
        return "cat";
    }
}

class CockerSpabiel extends Dog implements FriendLy {

    public void sayHello() {
        super.sayHello();
    }

    @Override
    public void sayGoodbye() {

    }

    public void sayGoodBye() {
    }

}

public class VirtualMethodTables {
}
