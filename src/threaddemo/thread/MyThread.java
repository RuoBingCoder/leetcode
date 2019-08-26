package threaddemo.thread;

/**
 * @author : 石建雷
 * @date :2019/8/5
 */

public class MyThread extends Thread {
    public volatile static int count;
//    public static int count;

    /**
     * 关于volatile的非原子性
     * <p>
     * 1.volatile仅能使用在变量级别；  synchronized则可以使用在变量、方法、和类级别的
     * 2.volatile仅能实现变量的修改可见性，并不能保证原子性；synchronized则可以保证变量的修改可见性和原子性
     * 3.volatile不会造成线程的阻塞； synchronized可能会造成线程的阻塞。
     * 4.volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化
     */
    private static synchronized void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }


}

