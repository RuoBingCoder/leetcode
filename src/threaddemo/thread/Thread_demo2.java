package threaddemo.thread;

/*
 * @author:石建雷
 * @data: 2018.11.3
 *
 */
public class Thread_demo2 {


    public static void main(String[] args) {

        ShareData data1 = new ShareData();
        new Thread(new MyRunnable1(data1)).start();
        new Thread(new MyRunnable2(data1)).start();

    }


    static class MyRunnable1 implements Runnable {

        private ShareData data1;

        public MyRunnable1(ShareData data1) {
            this.data1 = data1;
        }

        @Override
        public void run() {
            while (true) {
                data1.increment();//加

            }
        }
    }

    static class MyRunnable2 implements Runnable {

        private ShareData data2;

        public MyRunnable2(ShareData data2) {
            this.data2 = data2;
        }

        @Override
        public void run() {
            while (true) {

                data2.decrement();
                //减
            }
        }

    }
}

class ShareData {

    private int j = 100;

    public synchronized void increment() {
        while (j <= 50) {
            j++;
            System.out.println(ThreadExtThread.currentThread().getName() + ":" + j);
        }
    }

    public synchronized void decrement() {
        while (j > 50) {
            j--;
            System.out.println(ThreadExtThread.currentThread().getName() + ":" + j);
        }
    }
}




