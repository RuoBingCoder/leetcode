package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/19
 */

public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("迪丽热巴");
        list.add("马尔扎哈");
        list.add("张三丰");
        list.add("老顽童");

        list.stream().filter(name -> name.length() == 3).filter(s -> s.startsWith("张")).forEach(System.out::println);

        int i = 0;
        int j = 5;
        i = j > 6 ? 3 : 9;
        System.out.println(i);
        System.out.println(365674 % 8);
        System.out.println(365674 & 7);

    }
}
