package interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : 石建雷
 * @date :2019/8/21
 * 可见性，不保证原子性，禁止指令重拍
 */

public class VolatileDemo1 {

    volatile int v = 0;


    public void method1() {
        v = 60;
    }

    public static void main(String[] args) {
        VolatileDemo1 volatileDemo1 = new VolatileDemo1();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            volatileDemo1.method1();

        }, "AAA").start();

        while (volatileDemo1.v == 0) {
            System.out.println(Thread.currentThread().getName() + volatileDemo1.v);
        }
        System.out.println(Thread.currentThread().getName() + volatileDemo1.v);
    }


}
