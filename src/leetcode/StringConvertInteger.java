package leetcode;

/**
 * @author : 石建雷
 * @date :2019/5/2
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-9128347233200000000000"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 */

public class StringConvertInteger {
    public int myAtoi(String str) {
        int num = 0;
        String tempStr = null;
        String strTrim = str.trim();
        if ("".equals(strTrim) || "-".equals(str) || "+".equals(str)) {
            return 0;
        }
        char[] chars = strTrim.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = (chars[0] < '0' || chars[0] > '9') && chars[0] != '-' && chars[0] != '+';
            if (flag) {
                return 0;
            }
            boolean bl = (chars[i] >= '0' && chars[i] <= '9') || (chars[0] == '-') || chars[0] == '+';
            if (bl) {
                sb.append(chars[i]);
                if (i < chars.length - 1) {

                    if ((chars[0] == chars[1] && chars[0] == '-')) {
                        return 0;

                    } else if (chars[0] == '+' && chars[1] == '-' || chars[0] == chars[1] && chars[0] == '+' || chars[0] == '-' && chars[1] == '+') {
                        return 0;

                    } else {
                        if (chars[chars.length - 1] < '0' || chars[chars.length - 1] > '9') {

                            if (!(chars[i + 1] >= '0' && chars[i + 1] <= '9')) {
                                break;
                            }
                        } else if (chars[chars.length - 1] >= '0' || chars[chars.length - 1] <= '9') {

                            if (!(chars[i + 1] >= '0' && chars[i + 1] <= '9')) {
                                break;
                            } else if ((i + 1) == chars.length - 1) {
                                sb.append(chars[i + 1]);
                                break;
                            }
                        }
                    }
                }
            }
        }
        boolean exists = "-".equals(sb.toString()) || "+".equals(sb.toString()) && sb.length() == 1;
        String firstPlus = sb.toString().substring(0, 1);
        String firstMinus = sb.toString().substring(0, 1);
        if (exists) {
            return 0;
        }

        if (sb.length() >= 2) {
            if (!("-".equals(sb.toString().substring(0, 1))) && !("+".equals(sb.toString().substring(0, 1)))) {
                tempStr = sb.toString().replaceFirst("^0*", "");
                Integer x = getInteger(tempStr);
                if (x != null) {
                    return x;
                }
            } else if ("-".equals(sb.toString().substring(0, 1))) {
                tempStr = sb.toString().replaceFirst("-", "");
                tempStr = tempStr.replaceFirst("^0*", "");
                if ("".equals(tempStr)) {
                    return 0;
                }
                if (tempStr.length() > 10 || Long.parseLong(tempStr) > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
//正则表达式去除加号
            } else {
                boolean equals = "+".equals(firstPlus);
                if (equals) {
                    tempStr = sb.toString().replaceFirst("\\+", "");
                    tempStr = tempStr.replaceFirst("^0*", "");
                    Integer x = getInteger(tempStr);
                    if (x != null) {
                        return x;
                    }
                }
            }
        } else {
            tempStr = sb.toString();
        }

        long l1 = Long.parseLong(tempStr);
        if (l1 < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (l1 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            num = Integer.parseInt(sb.toString());
        }

        return num;

    }

    private Integer getInteger(String tempStr) {
        int number = 0;
        if ("".equals(tempStr)) {
            return number;
        }
        if (tempStr.length() > 10 || Long.parseLong(tempStr) > Integer.MAX_VALUE) {
            number = Integer.MAX_VALUE;
            return number;
        } else {
            number = Integer.parseInt(tempStr);
            return number;
        }
    }


    public static void main(String[] args) {
        StringConvertInteger convertInteger = new StringConvertInteger();
        System.out.println(convertInteger.myAtoi("-000000000000000000000000000214748364"));
        int a = -2147483648;
    }
}
