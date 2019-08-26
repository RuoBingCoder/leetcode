package single;

/**
 * @author : 石建雷
 * @date :2019/5/8
 * 双重验证机制
 */

public class SingleonDemo {
    /**
     * 理论上双重校验锁法是线程安全的，并且，这种方法实现了lazyloading。
     * Volatile关键字的作用: 禁止进行指令的重排序
     */
    private static volatile SingleonDemo singleonDemo = null;

    private SingleonDemo() {
    }

    public static SingleonDemo getInstance() {
        if (singleonDemo == null) {
            synchronized (SingleonDemo.class) {
                if (singleonDemo == null) {
                    singleonDemo = new SingleonDemo();
                }
            }
        }
        return singleonDemo;
    }
}
