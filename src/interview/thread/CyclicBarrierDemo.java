package interview.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : 石建雷
 * @date :2019/8/23
 */

public class CyclicBarrierDemo {
    /**
     * CyclicBarrier进行的是"减"
     *
     * @param args
     */
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("******召唤神龙！");
        });

        for (int i = 1; i <= 7; i++) {

            final int temp = i;
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + "龙珠 :" + temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "A" + temp).start();
        }
    }

}
