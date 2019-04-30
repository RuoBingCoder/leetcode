package lintcode;

import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/4/29
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * *
 * * 有效字符串需满足：
 * *
 * *
 * * 左括号必须用相同类型的右括号闭合。
 * * 左括号必须以正确的顺序闭合。
 * *
 * *
 * * 注意空字符串可被认为是有效字符串。
 * *
 * * 示例 1:
 * *
 * * 输入: "()"
 * * 输出: true
 * *
 * *
 * * 示例 2:
 * *
 * * 输入: "()[]{}"
 * * 输出: true
 * *
 * *
 * * 示例 3:
 * *
 * * 输入: "(]"
 * * 输出: false
 * *
 * *
 * * 示例 4:
 * *
 * * 输入: "([)]"
 * * 输出: false
 * *
 * *
 * * 示例 5:
 * *
 * * 输入: "{[]}"
 * * 输出: true
 * *
 */


public class YouXiaoKuoHao {

    private boolean isValid(String s) {
        if ("".equals(s)) {
            return false;
        }
        Stack<Character> stackChar = new Stack<>();
        char[] chars = s.toCharArray();
        boolean bol = false;
        if (chars.length % 2 == 0) {
            for (int i = 0; i < s.length(); i++) {
                if (chars[i] == ' ' || chars[0] == ')' || chars[0] == ']' || chars[0] == '}') {
                    return false;
                } else {
                    if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                        stackChar.push(chars[i]);
                    } else if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
                        if (stackChar.isEmpty()) {
                            bol = false;
                            break;
                        }
                        boolean isTrue = (stackChar.peek() == '(' && chars[i] == ')') || (stackChar.peek() == '[' && chars[i] == ']') || (stackChar.peek() == '{' && chars[i] == '}');
                        if (isTrue) {
                            stackChar.pop();
                            if (stackChar.size() == 0) {
                                bol = true;
                            }
                        } else {
                            bol = false;
                            break;
                        }
                    }
                }
            }

        }
        return bol;

    }

    public static void main(String[] args) {

        YouXiaoKuoHao youXiaoKuoHao = new YouXiaoKuoHao();
        String str = "[[[]";
        boolean bool = youXiaoKuoHao.isValid(str);

        System.out.println(bool);

    }
}
