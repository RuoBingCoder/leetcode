package hello;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author : 石建雷
 * @date :2019/7/30
 */

public class HelloWord {

    int notVarible = 12;

    public int num(int i, int j) {
        return 1;
    }

    public int num(int j) {
        return 1;
    }


    public static void hasValue(String username) {

        username = "李四";

    }


    public static void main(String[] args) {
       /* String str = "hello";
        int i = str.hashCode() % 8;
        int j = str.hashCode() & 7;
        System.out.println(str.hashCode());
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        int m = 1;
        System.out.println(2 << 1);
        short s = 128;
        byte b = (byte) s;
        System.out.println(b);
        System.out.println("===================================");
        String str1 = new String("abc");
        System.out.println("abc".equals(str1));
        System.out.println(str1 == "abc");*/

        String s1 = "he" + new String("llo");
        String s2 = "hello";
        System.out.println(s1 == s2 ? true : false);
//        equals比的是内容相等，而==比的是地址值是否相等
        System.out.println(s1.equals(s2) ? true : false);

        String s = "hello";
        s = s + "word";
        System.out.println(s);
        String username = "张三";
        hasValue(username);
        System.out.println(username);
        if (username.equals("张三")) {
            System.out.println("我是" + username);
        }
        System.out.println("**************************************");
        String s3 = "1";
        s3 = 1 + s3;
        System.out.println(s3);
        System.out.println("********************&运算***********************");
        System.out.println(12 & 12 & 13);
        System.out.println("********************&运算***********************");
        System.out.println("********************^运算***********************");
        System.out.println(12 ^ 12);
        System.out.println("********************^运算***********************");

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("5", "v1");
        treeMap.put("7", "v2");
        treeMap.put("9", "v3");
        treeMap.put("4", "v4");
        treeMap.put("2", "v5");
        Set<Map.Entry<String, String>> entrySet = treeMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
}


}
