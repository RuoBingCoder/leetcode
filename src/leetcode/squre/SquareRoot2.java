package leetcode.squre;

/**
 * @author : 石建雷
 * @date :2019/7/5
 * 平方根2
 */

public class SquareRoot2 {
    public int mySqrt(int x) {
        if (0 == x) {
            return x;
        }
        int left = 1, right = x, mid = 0, lastMid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                lastMid = mid;
            }
        }

        return lastMid;
    }
    public static void main(String[] args) {

        SquareRoot2 squareRoot = new SquareRoot2();
        int temp = squareRoot.mySqrt(9);
        System.out.println(temp);
    }

}
