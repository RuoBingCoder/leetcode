package leetcode.squre;

/**
 * @author : 石建雷
 * @date :2019/7/4
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */

public class SquareRoot {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        long temp = 0;
        int number = x;
        boolean flag = false;
        while (temp >= 0) {
            temp = x / 2;
            if (temp * temp == number) {
                return (int) temp;
            }
            if (temp * temp > number) {
                if (!flag) {
                    x = (int) (temp - 1);
                    continue;

                } else {
                    return (int) (temp - 1);
                }
            }
            if (temp * temp < number) {
                x = x + 1;
                flag = true;
            }
        }

        return (int) temp;


    }

    public static void main(String[] args) {

        SquareRoot squareRoot = new SquareRoot();
        int temp = squareRoot.mySqrt(2147395599);
        System.out.println(temp);
    }
}
