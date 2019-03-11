package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Authur: ʯ����
 * @Date:2018/12/6
 */

public class SynchronizedExample {
    /**
     * �������´��룬ʹ�� ExecutorService ִ���������̣߳�
     * ���ڵ��õ���ͬһ�������ͬ������飬����������̻߳����ͬ����
     * ��һ���߳̽���ͬ������ʱ����һ���߳̾ͱ���ȴ���
     * synchronized ��ֻ������ͬһ����������������������ϵ�ͬ������飬�Ͳ������ͬ����
     */
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }


    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());
    }
   /*
   public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
        �������ϴ��룬�����̵߳����˲�ͬ�����ͬ������飬����������߳̾Ͳ���Ҫͬ����
        �����������Կ����������߳̽���ִ�С�
        output��0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9
    */
}
