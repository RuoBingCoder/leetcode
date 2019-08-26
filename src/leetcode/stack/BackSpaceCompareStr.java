package leetcode.stack;

import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/8/9
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 */

public class BackSpaceCompareStr {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stringStack1 = new Stack<>();
        Stack<Character> stringStack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stringStack1.push(S.charAt(i));
            } else if (stringStack1.isEmpty()) {
                continue;
            } else {
                stringStack1.pop();
            }
        }

        for (int j = 0; j < T.length(); j++) {
            if (T.charAt(j) != '#') {
                stringStack2.push(T.charAt(j));
            } else if (stringStack2.isEmpty()) {
                continue;
            } else {
                stringStack2.pop();
            }
        }


        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (!stringStack1.isEmpty()) {
            sb1.append(stringStack1.pop());
        }
        while (!stringStack2.isEmpty()) {
            sb2.append(stringStack2.pop());
        }

        if (sb1.toString().equals(sb2.toString())) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        BackSpaceCompareStr str = new BackSpaceCompareStr();
        String s = "a##c";
        String t = "#a#c";
        System.out.println(str.backspaceCompare(s, t));


    }
}

