package single;

/**
 * @author : 石建雷
 * @date :2019/5/8
 * 单例模式饿汉式，线程安全
 */

public class SingleHungry {
    private static SingleHungry singleHungry = new SingleHungry();

    private SingleHungry() {
    }

    public static SingleHungry getInstance() {
        return singleHungry;
    }
}
