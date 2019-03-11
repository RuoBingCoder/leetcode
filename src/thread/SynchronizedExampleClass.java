package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Authur: ʯ����
 * @Date:2018/12/6
 * ͬ��һ����
 */

public class SynchronizedExampleClass {

    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExampleClass e1=new SynchronizedExampleClass();
        SynchronizedExampleClass e2=new SynchronizedExampleClass();
        ExecutorService executorService = Executors.newCachedThreadPool();  //����һ�������̳߳أ�֧�ֶ�ʱ������������ִ�С�
        //�ӿ� java.util.concurrent.ExecutorService �������첽ִ�еĻ��ƣ����ҿ����������ں�ִ̨�С�
        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e2.func2());
    }

}
