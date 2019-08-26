package thread;


/**
 * @author : 石建雷
 * @date :2018/12/4
 */

public class ThreadTestTwo {

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        new Thread(test, "李老师").start();
        new Thread(test, "张老师").start();
        new Thread(test, "王老师").start();


    }


    static class ThreadTest implements Runnable {

        public int noteBook = 80;

        @Override
        public void run() {

            while (noteBook >= 0) {

                outPut();
                noteBook--;


            }


        }

        public synchronized void outPut() {

            if (noteBook > 0) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + noteBook);
            }

        }
    }

}




