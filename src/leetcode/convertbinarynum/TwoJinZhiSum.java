package leetcode.convertbinarynum;

/**
 * @author : 石建雷
 * @date :2019/6/15
 */

public class TwoJinZhiSum {
    /* 给定两个二进制字符串，返回他们的和（用二进制表示）。

     输入为非空字符串且只包含数字 1 和 0。

     示例 1:

     输入: a = "11", b = "1"
     输出: "100"
     示例 2:

     输入: a = "1010", b = "1011"
     输出: "10101"*/
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int al = a.length() - 1;
        int bl = b.length() - 1;
        int carry = 0;

        while (al >= 0 || bl >= 0) {
            int sum = carry;
            if (al >= 0) {
                sum += (a.charAt(al) - '0');
                al--;
            }
            if (bl >= 0) {
                sum += (b.charAt(bl) - '0');
                bl--;
            }
            result.append(sum % 2);

            carry = sum / 2;

        }

        if (carry != 0) {
            result.append(1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        TwoJinZhiSum twoJinZhiSum = new TwoJinZhiSum();
        String a = "1010";
        String b = "1011";
        System.out.println(twoJinZhiSum.addBinary(a, b));
    }

}
