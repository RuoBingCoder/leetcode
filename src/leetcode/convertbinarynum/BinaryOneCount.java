package leetcode.convertbinarynum;

/**
 * @author : 石建雷
 * @date :2019/7/25
 */

public class BinaryOneCount {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(BinaryOneCount.hammingWeight(-3));
        System.out.println(-4 & -5);
        System.out.println(-3 >> 1);
    }
}
