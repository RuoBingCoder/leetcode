package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/12
 */

public class MyQueue2 {
    List<Integer> list=new ArrayList<>();
    public MyQueue2() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       return list.remove(0);
    }

    /** Get the front element. */
    public int peek() {
        return list.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2=new MyQueue2();
        myQueue2.push(1);
        myQueue2.push(2);
        myQueue2.push(3);
        System.out.println(myQueue2.peek());
    }
}
