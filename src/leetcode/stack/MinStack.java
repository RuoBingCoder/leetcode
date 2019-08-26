package leetcode.stack;

import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/7/20
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

public class MinStack {
     Stack<Integer> stack = new Stack<>();
     Stack<Integer> integerStack = new Stack<>();
    int min = 0;

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (integerStack.isEmpty()) {
            integerStack.push(x);
        } else {
            if (integerStack.peek() < x) {
                integerStack.push(integerStack.peek());
            } else {
                integerStack.push(x);
            }
        }

    }

    public void pop() {
        stack.pop();
        integerStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {

        return integerStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
