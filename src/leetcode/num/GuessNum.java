package leetcode.num;

/**
 * @author : 石建雷
 * @date :2019/8/8
 * 猜数字
 */

public class GuessNum {

    public int guessNumber(int n) {
        int low = 1;
        int heigh = n;
        int mid = 0;
        while (low <= heigh) {
            mid = low + (heigh - low) / 2;
            if (guess(mid) == 1) {
                low = mid + 1;
            } else if (guess(mid) == -1) {
                heigh = mid - 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public int guess(int num) {
        return num;
    }
}
