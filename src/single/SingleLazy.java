package single;

/**
 * @author : 石建雷
 * @date :2019/5/8
 * 单例模式懒汉式，线程不安全，加上synchronized则线程安全
 */

public class SingleLazy {
    private static SingleLazy singleLazy = null;

    private SingleLazy() {
    }

    /**
     * 适合单线程
     */
    public static synchronized SingleLazy getInstance() {
        if (singleLazy == null) {
            singleLazy = new SingleLazy();
        }
        return singleLazy;
    }
}
