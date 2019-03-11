package cn.sxt.collection;

/**
 * @author : 石建雷
 * @date :2019/1/31
 */

public class Node {
    Node previous;

//    上一个节点

    Node next;
    //下一个节点


    Object element;
    //元素数据


    public Node(Node previous, Node next, Object element) {
        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }


    public Node(Object element) {
        super();
        this.element = element;
    }


}
