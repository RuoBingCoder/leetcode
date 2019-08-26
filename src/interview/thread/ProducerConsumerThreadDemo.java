package interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 石建雷
 * @date :2019/8/23
 */

public class ProducerConsumerThreadDemo {

    static int count = 0;
    static final String lock = "lock";

    private static Lock lock2 = new ReentrantLock();
    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private static final Condition notFull = lock2.newCondition();
    private static final Condition notEmpty = lock2.newCondition();

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {

                }
                lock2.lock();
                try {
                    while (count == 10) {
                        try {
                            notEmpty.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产了：" + count + "消息");
                    //唤醒消费者
                    notEmpty.signal();
                } catch (Exception e) {

                } finally {
                    lock2.unlock();
                }


            }).start();
        }

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {

                }
                lock2.lock();
                try {
                    while (count == 0) {
                        try {
                            notFull.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费了了：" + count + "消息");
                    notFull.signal();
                } finally {
                    lock2.unlock();
                }


            }).start();
        }
    }
}
