package hash;

/**
 * @author : 石建雷
 * @date :2019/4/12
 * 手动实现hashMap
 */

public class HashMap<K, V> {

    private static final Integer ARRAYSIZE = 16;
    private Node<K, V>[] tabel;


    public HashMap() {
        tabel=new Node[ARRAYSIZE];


    }

    public int size() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }


    public boolean containsKey(Object key) {
        return false;
    }


    public boolean containsValue(Object value) {
        return false;
    }


    public Object get(Object key) {
        return null;
    }


    public Object put(Object key, Object value) {


        return null;
    }


    public Object remove(Object key) {
        return null;
    }


}
