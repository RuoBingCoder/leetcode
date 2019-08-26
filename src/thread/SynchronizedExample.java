package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : 石建雷
 * @date :2018/12/6
 */

public class SynchronizedExample {
    /**
     * 对于以下代码，使用 ExecutorService 执行了两个线程，
     * 由于调用的是同一个对象的同步代码块，因此这两个线程会进行同步，
     * 当一个线程进入同步语句块时，另一个线程就必须等待。
     * synchronized 它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
     */
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }


    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());
    }
   /*
   public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
        对于以上代码，两个线程调用了不同对象的同步代码块，因此这两个线程就不需要同步。
        从输出结果可以看出，两个线程交叉执行。
        output：0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9
    */
}
