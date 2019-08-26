package leetcode.bitopertion;

/**
 * @author : 石建雷
 * @date :2019/8/26
 */

public class JishuOushu {

    public int integerReplacement(int n) {

      /*  if (n == 0) {
            return 0;
        }
        int count = 0;
        int count2 = 0;
        int temp = n;
        while (n != 1) {
            if ((n & 1) == 1) {
                n = n - 1;
                count++;
            } else if ((n & 1) == 0) {
                n = n / 2;
                count++;
            }
        }
        while (temp != 1) {
            if ((temp & 1) == 1) {
                temp = temp + 1;
                count2++;
            } else if ((temp & 1) == 0) {
                temp = temp / 2;
                count2++;
            }
        }

        if (count > count2) {
            return count2;
        }
        return count;*/
        int count = 0;
        long m = n;
        while (m != 1) {
            if (m % 2 == 0) {
                m >>= 1;
            } else if (m == 3) {// 3 另外拿出来
                return count + 2;
            } else if ((m & 2) == 2) {// 7 → +1 、 5 → -1

//                (m & 2) == 2等价于 ((m+1)/2)%2==0
                m += 1;
            } else {
                m -= 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        final JishuOushu jishuOushu = new JishuOushu();
        System.out.println(jishuOushu.integerReplacement(10000));
        System.out.println(3 & 2);
    }
}
