package absdemo;

/**
 * @author : 石建雷
 * @date :2019/7/31
 */

public class Cat extends Animal {
    public Cat() {
        super();
    }

    @Override
    public void eat() {
        System.out.println("我是一只猫");
    }

    public static void main(String[] args) {
        Cat cat=new Cat();
        cat.eat();
    }
}
