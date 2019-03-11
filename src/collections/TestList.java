package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试Collections接口的方法
 * ArrayList，LinkedList，HashMap,StringBuilder是不安全的。
 * vector,HashTable,StringBuffer是线程安全的
 *
 * @Authur: 石建雷
 * @Date:2019/1/3
 */

public class TestList {

    public static void test01() {

        List<String> list01 = new ArrayList<>();
        list01.add("aaa");
        list01.add("bbb");
        list01.add("ccc");


        List<String> list02 = new ArrayList<>();
        list02.add("aaa");
        list02.add("ddd");
        list02.add("eee");
        System.out.println(list01.containsAll(list02)); //  false  只包含了 "aaa"
        list01.retainAll(list02);
        System.out.println("list01:" + list01);  // list01:[aaa]
        list01.addAll(list02);
        System.out.println("list01:" + list01); // list01:[aaa, bbb, ccc, aaa, ddd, eee]
        list01.removeAll(list02);
        System.out.println("list01:" + list01);  // list01:[bbb, ccc]


    }

    public static void main(String[] args) {

        test01();
        int a=10;
        System.out.println(a>>1);

    }
}
