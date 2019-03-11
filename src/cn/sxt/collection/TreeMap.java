package cn.sxt.collection;

import java.util.HashMap;

/**
 * @author : 石建雷
 * @date :2019/2/11
 */

public class TreeMap {
    HashMap map;
    public static final Object PRESENT = new Object();

    public TreeMap() {
        map = new HashMap<>();
    }

    public void add(Object o) {
        map.put(o, PRESENT);
    }

    private int size() {
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Object key : map.keySet()) {
            builder.append(key+",");

        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.add("111");
        treeMap.add("222");
        treeMap.add("333");
        System.out.println(treeMap.toString());
    }
}
