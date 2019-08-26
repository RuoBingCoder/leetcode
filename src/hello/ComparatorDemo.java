package hello;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : 石建雷
 * @date :2019/8/18
 */

public class ComparatorDemo {

    public static Comparator<String> compare() {
        return (o1, o2) -> o1.length() - o2.length();
    }

    public static void main(String[] args) {
        String[] str = {"qbc", "yfge", "uefwirf", "ghfadvsvg"};

        Arrays.sort(str, compare());
        System.out.println(Arrays.toString(str));
    }
}
