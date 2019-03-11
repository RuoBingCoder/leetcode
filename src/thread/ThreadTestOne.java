package thread;

/**
 * @Authur: Ê¯½¨À×
 * @Date:2018/12/4
 */

public class ThreadTestOne implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            System.out.print("new ");

        }
        System.out.println(" ");
    }


    public static void main(String[] args) {
        System.out.println("****Main thead:");
        for (int i = 0; i < 25; i++) {
            System.out.println("main");

        }

        System.out.println("****New Thead:");
        ThreadTestOne testOne = new ThreadTestOne();
        Thread thread = new Thread(testOne);
        thread.start();


    }


}
