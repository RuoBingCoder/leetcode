package interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author JianLeiComputer
 */
public class SingleDemo {
    //    加上volatile防止指令重排
    private static volatile SingleDemo ourInstance = null;

    /**
     * DCL  双重检索机制
     *
     * @return ourInstance
     */
    public static synchronized SingleDemo getInstance() {
        if (ourInstance == null) {
            synchronized (SingleDemo.class) {
                if (ourInstance == null) {
                    ourInstance = new SingleDemo();
                    System.out.println(Thread.currentThread().getName() + "ourInstance：" + ourInstance.toString());
                }
            }
        }
        return ourInstance;
    }

    private SingleDemo() {


    }

    public static void main(String[] args) {
        SingleDemo singleDemo = new SingleDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                getInstance();


            }).start();
        }
    }
}
