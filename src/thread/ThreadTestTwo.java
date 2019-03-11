package thread;


/**
 * @Authur: 石建雷
 * @Date:2018/12/4
 */

public class ThreadTestTwo {

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        new Thread(test, "李老师").start();
        new Thread(test, "张老师").start();
        new Thread(test, "王老师").start();


    }


    static class ThreadTest implements Runnable {

        public int NoteBook = 80;

        @Override
        public void run() {

            while (NoteBook >= 0) {

                outPut();
                NoteBook--;


            }


        }

        public synchronized void outPut() {

            if (NoteBook > 0) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + NoteBook);
            }

        }
    }

}




