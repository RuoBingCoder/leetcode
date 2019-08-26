package interview.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author : 石建雷
 * @date :2019/8/23
 */

public class CountDownLatchDemo {

    private CountDownLatch countDownLatch = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":线程开始！");
                countDownLatchDemo.countDownLatch.countDown();
            }, "A" + i).start();
        }
        countDownLatchDemo.countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + ":程序走完！");
    }
}
