package leetcode;

/**
 * @author : 石建雷
 * @date :2019/3/30
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * *
 * * 示例 1:
 * *
 * * 输入: 121
 * * 输出: true
 * *
 * *
 * * 示例 2:
 * *
 * * 输入: -121
 * * 输出: false
 * * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * *
 * *
 * * 示例 3:
 * *
 * * 输入: 10
 * * 输出: false
 * * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * *
 * *
 * * 进阶:
 * *
 * * 你能不将整数转为字符串来解决这个问题吗？
 */

public class HuiWenShu {
    private boolean isPalindrome(int x) {
        int temp;
        int number = 0;
        int temp1 = x;
        while (x != 0) {

            temp = x % 10;
            if (temp < 0) {
                return false;
            }
            x /= 10;
            number = number * 10 + temp;

        }


        return number == temp1;
    }

    public static void main(String[] args) {

        HuiWenShu huiWenShu = new HuiWenShu();
        boolean b = huiWenShu.isPalindrome(12344321);
        System.out.println(b);


    }

}
