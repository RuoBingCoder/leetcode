package leetcode;

/**
 * @author : 石建雷
 * @date :2019/6/9
 * 1.     1
 * 2.     11
 * 3.     21  一个二 一个一
 * 4.     1211  一个二 两个一
 * 5.     111221  一个1 一个2 两个1
 * 6.      312211
 * 7.       13112221
 */

public class Baoshu {
    /**
     * 引用别人的一道算法，学到了递归的精妙
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String beagin = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int len = beagin.length();
        int count = 1;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                sb.append(count);
                sb.append(beagin.charAt(i));
                break;
            }
            if (beagin.charAt(i + 1) == beagin.charAt(i)) {
                count++;
                continue;
            } else {
                sb.append(count);
                sb.append(beagin.charAt(i));
                count = 1;

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Baoshu baoshu = new Baoshu();
        System.out.println(baoshu.countAndSay(29));
    }

}
