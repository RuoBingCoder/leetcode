import java.util.*;

/**
 * @author : 石建雷
 * @date :2019/8/11
 */

public class ForHashMap {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("张三", "北京");
        hashMap.put("李四", "上海");
        hashMap.put("王五", "南京");
        hashMap.put("赵六", "西安");
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> value = iterator.next();
            System.out.println(value.getKey());
            System.out.println(value.getValue());

        }

    }
}
