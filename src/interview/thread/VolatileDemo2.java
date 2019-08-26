package interview.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : 石建雷
 * @date :2019/8/21
 * 可见性，不保证原子性，禁止指令重拍
 */

public class VolatileDemo2 {
    //    不保证原子性
    volatile int v = 0;
    //    保证原子性
    AtomicInteger atomicInteger = new AtomicInteger();

    public void method1() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    v++;
                    atomicInteger.getAndIncrement();
                }
            }, "BBB").start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "volatile :" + v);
        System.out.println(Thread.currentThread().getName() + "atomicInteger:" + atomicInteger);

    }


    public static void main(String[] args) {
        VolatileDemo2 volatileDemo2 = new VolatileDemo2();

        volatileDemo2.method1();


    }
}
