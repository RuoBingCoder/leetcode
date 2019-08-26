package absdemo;

/**
 * @author : 石建雷
 * @date :2019/7/31
 * 注意 :抽象方法所在类必须是抽象类
 * 抽象类可以有构造函数
 */

public abstract class Animal {

    public Animal() {
        System.out.println("父类的抽象方法");
    }

    public abstract void eat();

    /**
     * 抽象类可以有普通方法
     */
    public void sleep() {
        System.out.println("我在睡觉");
    }
}
