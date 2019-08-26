package leetcode.bitopertion;

/**
 * @author : 石建雷
 * @date :2019/8/22
 */

public class TwoMi {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoMi twoMi = new TwoMi();
        System.out.println(twoMi.isPowerOfTwo(-4));
    }
}
