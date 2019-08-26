package interview.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : 石建雷
 * @date :2019/8/24
 */

public class ThreadPoolDemo {
    /**
     * public static ExecutorService newFixedThreadPool(int nThreads) {
     * return new ThreadPoolExecutor(nThreads, nThreads,
     * 0L, TimeUnit.MILLISECONDS,
     * new LinkedBlockingQueue<Runnable>());  底层通过阻塞队列实现
     * }
     */
    private Executor executor = Executors.newFixedThreadPool(5);   ///固定线程数
    private Executor executor2 = Executors.newSingleThreadExecutor();   ///单个线程数
    private Executor executor3 = Executors.newCachedThreadPool();   ///N个线程数

    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPoolDemo.executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + finalI);

            });
        }

    }
}
