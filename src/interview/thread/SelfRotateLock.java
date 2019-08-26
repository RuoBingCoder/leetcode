package interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : 石建雷
 * @date :2019/8/22
 * 自旋锁
 */

public class SelfRotateLock {


    static AtomicReference atomicReference = new AtomicReference<>();


    public static void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ":mylock");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public static void myunLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + ":unLock");



    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myunLock();

        }, "t1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {

            myLock();
            myunLock();


        }, "t2").start();
    }
}
