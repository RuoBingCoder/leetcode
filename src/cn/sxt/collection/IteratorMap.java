package cn.sxt.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author : 石建雷
 * @date :2019/2/11
 */

public class IteratorMap {
    private void testMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(100, "张三");
        map.put(101, "李四");
        map.put(102, "王五");
        /**
         *迭代器
         */
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + "----" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        IteratorMap iteratorMap = new IteratorMap();
        iteratorMap.testMap();

    }
}
