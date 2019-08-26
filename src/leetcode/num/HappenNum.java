package leetcode.num;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : 石建雷
 * @date :2019/7/30
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

public class HappenNum {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum=0;
        while (true) {
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;

            }
            if (sum == 1) {
                return true;
            } else if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                n = sum;
                sum = 0;

            }
        }


    }

    /*public int result(int n, int temp) {
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        if (temp * temp == sum && temp < 10) {
            return -1;
        }
        n = sum;
        return result(n, temp);
    }*/

    public static void main(String[] args) {
        HappenNum happenNum = new HappenNum();
        System.out.println(happenNum.isHappy(11));
//        65,61,37,30,9
    }
}
