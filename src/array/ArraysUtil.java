package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/7/25
 */

public class ArraysUtil {

    public static <T> List<T> asList(T[] array) {
        List<T> list = new ArrayList<>(Arrays.asList(array));
        return list;
    }

    public static void main(String[] args) {
        String[] array = {"2", "4", "12", "56", "34"};
        List<String> stringList = ArraysUtil.asList(array);
        stringList.remove(1);
        System.out.println(stringList.toString());
        System.out.println(stringList.size());
    }
}
