package interview.thread;

/**
 * @author : 石建雷
 * @date :2019/8/24
 * 死锁
 */


class MyThread implements Runnable {

    private String lock1;
    private String lock2;

    public MyThread(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + ":lock1 获取" + lock2);
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + ":lock2 获取" + lock1);
            }
        }
    }
}

public class DeadLockDemo {

    public static void main(String[] args) {
        String lock1 = "Lock1";
        String lock2 = "Lock2";

        new Thread((new MyThread(lock1, lock2)), "AAA").start();
        new Thread((new MyThread(lock2, lock1)), "BBB").start();


    }
}
