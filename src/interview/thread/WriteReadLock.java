package interview.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : 石建雷
 * @date :2019/8/22
 */

public class WriteReadLock {


    private Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写开始...");
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写结束！");
        } catch (Exception e) {

        } finally {
            readWriteLock.writeLock().unlock();

        }

    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取开始！");
            TimeUnit.MICROSECONDS.sleep(300);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成！" + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


    public static void main(String[] args) {
        WriteReadLock writeReadLock = new WriteReadLock();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                writeReadLock.put("key" + finalI, "value:" + finalI);
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                writeReadLock.get("key" + finalI);
            }).start();
        }
    }
}
