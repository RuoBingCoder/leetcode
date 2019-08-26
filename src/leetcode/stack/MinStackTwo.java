package leetcode.stack;

import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/7/20
 */

public class MinStackTwo {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public MinStackTwo() {

    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    public void pop() {
        int top = stack.pop();
        if (top == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {

        return min;
    }
    public static void main(String[] args) {
        MinStackTwo minStackTwo = new MinStackTwo();
        minStackTwo.push(3);
        minStackTwo.push(2);
        minStackTwo.push(-8);
        minStackTwo.push(15);
        minStackTwo.push(4);
        minStackTwo.push(-10);
        System.out.println(minStackTwo.getMin());
        minStackTwo.pop();
        minStackTwo.pop();
        System.out.println(minStackTwo.top());
        System.out.println(minStackTwo.getMin());
    }
}
