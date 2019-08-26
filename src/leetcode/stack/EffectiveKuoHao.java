package leetcode.stack;

import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/8/13
 * 入："(()())(())"
 * 输出："()()()"
 * 解释：1,2,1,2,1,0,  1,2,1,0,
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："( ()() ) (()) ( ()(()) )"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 */

public class EffectiveKuoHao {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0 || s.equals("")) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (!stack.isEmpty()) {
                    sb.append(s.charAt(i));

                }
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(s.charAt(i));

                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        EffectiveKuoHao kuoHao = new EffectiveKuoHao();
        String str = "(()())(())";
        String str3 = "()()";
        String str2 = "(()())(())(()(()))";
        System.out.println(kuoHao.removeOuterParentheses(str3));
    }
}
