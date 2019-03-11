package cn.sxt.collection;

/**
 * @author : 石建雷
 * @date :2019/1/31
 * hashMap实现原理，通过数组加链表的方式实现，运用散列
 */

public class HashMapDemo1 {
    Node2[] table;
    //    节点数组
    int size;

    public HashMapDemo1() {
        table = new Node2[16];
    // 一般定义为2的整数次幂

    }

    public void put(Object key, Object value) {
        Node2 node2 = new Node2();
        node2.hash = myhash(key.hashCode(), table.length);
        node2.key = key;
        node2.value = value;
        node2.next = null;
        Node2 temp = table[node2.hash];
        Node2 iterLast = null;
        boolean keyRepeat = false;
        if (temp == null) {
            table[node2.hash] = node2;
            size++;
        } else {
            //此处数组元素不为空。则遍历对应链表。。
            while (temp != null) {
                if (temp.key.equals(key)) {
                    // 判断重复，如果重复则覆盖，其他值不变
                    keyRepeat = true;
                    temp.value = value;
                    break;
                } else {
                    temp = iterLast;
                    temp = temp.next;
                }

            }
            if (!keyRepeat) {
                iterLast.next = node2;
                size++;
            }
        }

    }

    public int myhash(int v, int length) {
        return v & (length - 1);
//        直接位运算效率高
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            Node2 temp = table[i];
            while (temp != null) {
                builder.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        builder.setCharAt(builder.length() - 1, '}');
        return builder.toString();

    }

    public static void main(String[] args) {
        HashMapDemo1 demo1 = new HashMapDemo1();
        demo1.put(101, "张三");
        demo1.put(102, "李四");
        System.out.println(demo1.toString());
    }
}
