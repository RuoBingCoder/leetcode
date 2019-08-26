package interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : 石建雷
 * @date :2019/8/24
 * 阻塞队列demo
 */

public class ProConBlockQueueDemo {

    private BlockingQueue blockingQueue;
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public ProConBlockQueueDemo(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void pro() throws InterruptedException {
        String data = null;
        boolean result;
        while (flag) {

            data = atomicInteger.incrementAndGet() + "";
            result = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "插入队列" + data + "成功");

            } else {
                System.out.println(Thread.currentThread().getName() + "插入队列" + data + "失败");

            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "老板叫停！flag=false");
    }

    public void con() throws InterruptedException {
        String data = null;

        while (flag) {
            data = (String) blockingQueue.poll(2L, TimeUnit.SECONDS);

            if (null == data && data.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "超过2秒没有取到数据");
                System.out.println();
                System.out.println();

            }
            System.out.println(Thread.currentThread().getName() + "消费数据" + data + "成功");
        }
    }


    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ProConBlockQueueDemo proConBlockQueueDemo = new ProConBlockQueueDemo(new ArrayBlockingQueue(10));
        new Thread(() -> {
            try {
                proConBlockQueueDemo.pro();
            } catch (Exception e) {

            }

        }, "pro").start();

        new Thread(() -> {
            try {
                proConBlockQueueDemo.con();
            } catch (Exception e) {

            }
        }, "con").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("停.....");
        proConBlockQueueDemo.stop();
    }
}
