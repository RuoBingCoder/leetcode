package interview.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 石建雷
 * @date :2019/8/22
 * <p>
 * 可重入锁（递归锁）
 */

public class ReenterLock implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        set();
//        method1();
    }

    public static synchronized void method1() {
        System.out.println(Thread.currentThread().getId() + ": method1 lock...");
        method2();
    }

    private static synchronized void method2() {
        System.out.println(Thread.currentThread().getId() + ": method2 lock...");
    }
//=====================================================================================

    public void set() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ": lock set!");
            get();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ": lock get!");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReenterLock reenterLock = new ReenterLock();
        new Thread(reenterLock, "t1").start();
        new Thread(reenterLock, "t2").start();
    }
}
