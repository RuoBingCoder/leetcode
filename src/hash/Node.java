package hash;

/**
 * @author : 石建雷
 * @date :2019/4/12
 */

public class Node<K, V> {
    int hash;
    Object key;
    Object value;
    Node<K, V> next;
}
