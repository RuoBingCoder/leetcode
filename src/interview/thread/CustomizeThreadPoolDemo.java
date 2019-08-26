package interview.thread;

import java.util.concurrent.*;

/**
 * @author : 石建雷
 * @date :2019/8/24
 * 自定义线程池
 */

public class CustomizeThreadPoolDemo {

    public static void main(String[] args) {
        /**
         * AbortPolicy 当队列满时抛异常         new ThreadPoolExecutor.AbortPolicy()
         * new ThreadPoolExecutor.CallerRunsPolicy() 调用主线程
         *   new ThreadPoolExecutor.DiscardPolicy() 抛弃多余的
         */
        Executor executor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

//  new LinkedBlockingDeque<>(3) 参数 有个负载因子 线程数/(1-0.7~0.9)
        for (int i = 0; i < 9; i++) {
            int finalI = i;
            executor.execute(() -> {

                System.out.println(Thread.currentThread().getName() + ":" + finalI);

            });
        }
        ((ThreadPoolExecutor) executor).shutdown();
//        获得CPU核心数
        System.out.println(Runtime.getRuntime().availableProcessors());
        byte[] bytes = new byte[1024 * 1024 * 50];


     }

}
