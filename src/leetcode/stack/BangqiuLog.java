package leetcode.stack;

import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/8/12
 * ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * <p>
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 */

public class BangqiuLog {
    public int calPoints(String[] ops) {
        Stack<Integer> characterStack = new Stack<>();
        int result = 0;
        for (int i = 0; i < ops.length; i++) {
            if ("C".equals(ops[i])) {
                characterStack.pop();
            } else if ("D".equals(ops[i])) {
                characterStack.push(characterStack.peek() * 2);
            } else if ("+".equals(ops[i])) {
                int num = characterStack.pop();
                int num1 = characterStack.pop();
                characterStack.push(num1);
                characterStack.push(num);
                characterStack.push(num + num1);
            } else {
                characterStack.push(Integer.valueOf(ops[i]));
            }

        }
        while (!characterStack.isEmpty()) {
            result += characterStack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BangqiuLog bangqiuLog = new BangqiuLog();
        String[] str = {"5", "2", "C", "D", "+"};
        String[] str1 = {"5","-2","4","C","D","9","+","+"};
        System.out.println(bangqiuLog.calPoints(str1));
    }
}
