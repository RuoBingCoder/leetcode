package hash;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 石建雷
 * @date :2019/8/25
 */

public class HashNoSafeDemo implements Runnable {
    static ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>(20000);
//    static volatile HashMap<Object, Object> hashMap = Maps.newHashMap();
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
//        lock.lock();
        try {
            for (int i = 0; i < 5000; i++) {
                hashMap.put(i, i);
            }
        } finally {
//            lock.unlock();
        }

      /*  try {
            TimeUnit.MICROSECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(Thread.currentThread().getName() + "\t");
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new HashNoSafeDemo()).start();
        Thread.sleep(1);
        new Thread(new HashNoSafeDemo()).start();
        Thread.sleep(1);
        new Thread(new HashNoSafeDemo()).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(hashMap.size());

    }


}
