package java_thread;

/*
 * @author:石建雷
 * @data: 2018.10.21
 *
 */
public class Thread_demo {

    public static void main(String[] args) {
        /*
         * 线程的同步与死锁
         *
         */

        final Output output = new Output();  //注意当外部类访问内部类时，内部类要设置为静态的。
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    output.ouput("lihuawei");
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    output.ouput("zhangxiaoqiang");
                }

            }
        }).start();
    }

    static class Output {

        public void ouput(String name) {

            int len = name.length();
            synchronized (this) {  //this指的当前对象Output
                for (int i = 0; i < len; i++) {

                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }
    }
   /* public synchronized void ouput(String name) {
        另一种写法
        int len = name.length();

            for (int i = 0; i < len; i++) {

                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }*/

}
