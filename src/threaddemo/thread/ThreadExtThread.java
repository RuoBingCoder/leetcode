package threaddemo.thread;

/**
 * @author : 石建雷
 * @date :2019/7/19
 */

public class ThreadExtThread extends Thread {

    public void threadOne() {
        System.out.println("线程2.....");
    }
    public void threadTwo() {
        System.out.println("线程2.....");
    }
    public static void main(String[] args) {
        ThreadExtThread threadExtThread = new ThreadExtThread();
        threadExtThread.threadOne();
        Thread thread = new Thread(threadExtThread);
        thread.start();

    }
}
