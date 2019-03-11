package datastructure;

/**
 * @author : 石建雷
 * @date :2019/1/28
 * 下压堆栈的实现（链表实现）
 */

public class Stack<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * @param item 像栈顶添加元素
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;

    }

    /**
     * @return
     */
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }


}
