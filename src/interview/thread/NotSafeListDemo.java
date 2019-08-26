package interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : 石建雷
 * @date :2019/8/22
 * 线程不安全
 */

public class NotSafeListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

//   1.解决办法1     List<String> list1 = new Vector<>();
//      2.  List<String> list1 = Collections.synchronizedList(list);
//     3.   List<String> list1 = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 300; i++) {
            new Thread(() ->
            {

                list.add(UUID.randomUUID().toString().substring(0, 6));

                list.forEach(System.out::println);
            }).start();
        }


    }
}
