package interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : 石建雷
 * @date :2019/8/23
 * 阻塞队列
 */

public class BlockingQueueDemo {
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);


        /**
         *
         System.out.println(blockingQueue.add("a"));
         System.out.println(blockingQueue.add("a"));
         System.out.println(blockingQueue.add("a"));

         System.out.println(blockingQueue.add("b"));
         * true
         * true
         * true
         * Exception in thread "main" java.lang.IllegalStateException: Queue full
         * 	at java.util.AbstractQueue.add(AbstractQueue.java:98)
         * 	at java.util.concurrent.ArrayBlockingQueue.add(ArrayBlockingQueue.java:312)
         * 	at interview.thread.BlockingQueueDemo.main(BlockingQueueDemo.java:20)
         * 	add()队列满时抛异常
         *
         */


        System.out.println("======================================================");

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
    }
}
