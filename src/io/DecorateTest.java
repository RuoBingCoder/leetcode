package io;

/**
 * @author : 石建雷
 * @date :2019/3/4
 * 装饰器
 * 1、抽象组件:需要装饰的抽象对象(接口或抽象父类)
 * 2、具体组件:需要装饰的对象
 * 3、抽象装饰类:包含了对抽象组件的引用以及装饰着共有的方法
 * 4、具体装饰类:被装饰的对象
 */

public class DecorateTest {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink milk = new Milk(coffee);
        //装饰
        System.out.println(milk.cost() + "----->" + milk.info());
    }
}

interface Drink {
    Double cost();

    String info();  //说明
}

class Coffee implements Drink {
    private String name = "原味咖啡";

    @Override
    public Double cost() {
        return 10.0;
    }

    @Override
    public String info() {
        return name;
    }
}

abstract class Decorate implements Drink {
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public Double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

class Milk extends Decorate {

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public Double cost() {
        return super.cost() * 4;
    }

    @Override
    public String info() {
        return super.info() + "加入了牛奶";
    }
}

