package leetcode;

import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/2/2
 */

public class PushOrPopStack {
    /**
     * 题目要求：实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
     * <p>
     * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
     * <p>
     * 样例
     * 如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1
     */
    private static Stack<Integer> stack;
    private static Stack<Integer> minStack;


    public PushOrPopStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    /**
     * @param number
     */
    public void push(int number) {

        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);

        } else {
            if (number <= minStack.peek()) {
                //  minStack.peek()栈顶元素不删除栈顶，pop()栈顶元素删除元素
                minStack.push(number);
            }
        }

    }

    /*
     * @return: An integer
     * 出栈
     */
    public int pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();

    }

    /*
     * @return: An integer
     */
    public int min() {

        return minStack.peek();
    }

    public static void main(String[] args) {
        PushOrPopStack pushOrPopStack = new PushOrPopStack();
        pushOrPopStack.push(3);
        pushOrPopStack.push(6);
        pushOrPopStack.push(2);
        pushOrPopStack.pop();
        System.out.println(pushOrPopStack.min());
    }
}
