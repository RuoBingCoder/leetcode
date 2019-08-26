package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : 石建雷
 * @date :2018/12/6
 * 同步一个类
 */

public class SynchronizedExampleClass {

    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExampleClass e1=new SynchronizedExampleClass();
        SynchronizedExampleClass e2=new SynchronizedExampleClass();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建一个定长线程池，支持定时及周期性任务执行。
        //接口 java.util.concurrent.ExecutorService 表述了异步执行的机制，并且可以让任务在后台执行。
        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e2.func2());
    }

}
