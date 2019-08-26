package interview.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : 石建雷
 * @date :2019/8/23
 * 同步队列
 */

public class SynchronousQueueDemo {

    static SynchronousQueue synchronousQueue = new SynchronousQueue();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始放：1");
                synchronousQueue.put(1);
                System.out.println(Thread.currentThread().getName() + "开始放：2");
                synchronousQueue.put(2);
                System.out.println(Thread.currentThread().getName() + "开始放：3");
                synchronousQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "AAA").start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "开始取：1");
                synchronousQueue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "开始取：2");
                synchronousQueue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "开始取：3");
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "BBB").start();
    }
}
