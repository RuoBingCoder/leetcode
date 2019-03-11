package thread;

/**
 * @Authur: 石建雷
 * @Date:2018/12/17 卖票案例, 线程不安全
 */

class SellTicketDemo extends Thread {

    private String name;
    private int num = 50;

    public SellTicketDemo(String name) {
        super();
        this.name = name;

    }

    @Override
    public void run() {
        for (int i = 1; i <= num; i++) {

            System.out.println(name + "卖出了第" + i + "张票");


        }
    }
}

class MySell implements Runnable {
    private int num = 50;


    @Override
    public void run() {
        synchronized (this) {    //控制线程安全
            for (int i = 1; i <= num; i++) {

                System.out.println(Thread.currentThread().getName() + "卖出了第" + i + "张票");
            }
        }
    }
}

public class SellTicket {
    public static void main(String[] args) throws Exception {
        new SellTicketDemo("A").start();
        new SellTicketDemo("B").start();
        new SellTicketDemo("C").start();
        new Thread(new MySell(), "D").start();
        new Thread(new MySell(), "E").start();
        new Thread(new MySell(), "F").start();

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);

        }


    }


}
