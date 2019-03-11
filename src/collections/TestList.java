package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * ����Collections�ӿڵķ���
 * ArrayList��LinkedList��HashMap,StringBuilder�ǲ���ȫ�ġ�
 * vector,HashTable,StringBuffer���̰߳�ȫ��
 *
 * @Authur: ʯ����
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
        System.out.println(list01.containsAll(list02)); //  false  ֻ������ "aaa"
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
