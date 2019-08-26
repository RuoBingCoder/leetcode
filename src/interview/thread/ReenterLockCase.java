package interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 石建雷
 * @date :2019/8/23
 */

public class ReenterLockCase {


    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    private static int nums = 1;

    public static void prints(Condition ct1, Condition ct2, int len, int num, int temp, int add) {

        lock.lock();
        try {
            while (num != temp) {
                ct1.await();
            }
            for (int i = 1; i <= len; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = add;
            ct2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                prints(c1, c2, 5, 1, 1, 2);
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                prints(c2, c3, 10, 2, 2, 3);
            }

        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                prints(c3, c1, 15, 3, 3, 1);
            }

        }, "C").start();
    }

}
