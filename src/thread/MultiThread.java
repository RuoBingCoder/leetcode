package thread;

/**
 * @Authur: ʯ����
 * @Date:2018/12/6 1��ÿ��������һ����������ͬ�����ʣ�Synchronized�ؼ��ֿ��ԺͶ������������
 * ��ʵ��ͬ��������ͬ���顣sleep()��������ִ�е��߳������ó�CPU��Ȼ��CPU�Ϳ���ȥִ���������񣩣�
 * ��sleepָ��ʱ���CPU�ٻص����̼߳�������ִ��(ע�⣺sleep����ֻ�ó���CPU�����������ͷ�ͬ����Դ��������)��
 * wait()��������ָ��ǰ�߳����Լ���ʱ���ó�ͬ����Դ�����Ա��������ڵȴ�����Դ���̵߳õ�����Դ�������У�
 * ֻ�е�����notify()������֮ǰ����wait()���̲߳Ż���wait״̬������ȥ���뾺��ͬ����Դ���������õ�ִ�С�
 * ��ע�⣺notify�������൱�ڽ���˯�ŵ��ˣ�������������������񣬾���˵notifyֻ����֮ǰ����wait���߳���Ȩ��
 * ���²����̵߳ĵ��ȣ���
 * <p>
 * 2��sleep()�����������κεط�ʹ�ã�wait()������ֻ����ͬ��������ͬ������ʹ�ã�
 * <p>
 * 3��sleep()���߳��߳��ࣨThread���ķ��������û���ͣ���߳�ָ����ʱ�䣬�������Ȼ���֣�
 * �����ͷŶ���������ʱ���Զ��ָ���wait()��Object�ķ��������û����������������ȴ����У�
 * ������notify()/notifyAll()����ָ�����̻߳��������̣߳��Ż�������أ����ٴλ�ö������Ż��������״̬��
 */


public class MultiThread {

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            /*
             *���� Thread1������Thread2�ڲ�run����Ҫ��ͬһ������Ϊ��������
             *�����this��Thread1��Threa2��this����ͬһ����
             *������MultiThread.class����ֽ������
             *��ǰ������������������ʱָ��Ķ���ͬһ������
             */

            synchronized (MultiThread.class) {
                System.out.println("enter thread1 ...");
                System.out.println("thread1 is waiting");

                try {
            /**
             * �ͷ��������ַ�ʽ��(1)������Ȼ�뿪�������ķ�Χ��
             * ���뿪synchronized�ؼ��ֹ�Ͻ�Ĵ��뷶Χ
             * (2)��synchronized�ؼ��ֹ�Ͻ�Ĵ����ڲ����ü����������wait()����
             * ������ʹ��wait����
             */

                    MultiThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread1 is going on ...");
                System.out.println("thread1 is being over!");
            }
        }

    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            //notify���������ͷ�������ʹthread2�����������sleep������Ϣ10ms����thread1��Ȼ����ִ��
            //��Ϊthread2û���ͷ���������Thread1�ò��������޷�ִ��
            synchronized (MultiThread.class) {
                System.out.println("enter thread2 ...");
                System.out.println("thread2 notify other thread can release wait status ...");
                MultiThread.class.notify();
                System.out.println("thread2 is sleeping ten millisecond ...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread2 is going on ...");
                System.out.println("thread2 is being over!");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Thread2()).start();
    }

}


