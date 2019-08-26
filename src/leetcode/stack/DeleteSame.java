package leetcode.stack;

import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/8/10
 */

public class DeleteSame {
    public String removeDuplicates(String S) {
        Stack<Character> stringStack = new Stack<>();
        if (S.length() == 0) {
            return null;
        }
        for (int i = 0; i < S.length(); i++) {
            if (!stringStack.isEmpty() && S.charAt(i) == stringStack.peek()) {
                stringStack.pop();
            } else {
                stringStack.push(S.charAt(i));
            }

        }
        StringBuilder builder = new StringBuilder();
        while (!stringStack.isEmpty()) {
            builder.append(stringStack.pop());
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        DeleteSame deleteSame = new DeleteSame();
        System.out.println(deleteSame.removeDuplicates("abbaca"));
    }
}
