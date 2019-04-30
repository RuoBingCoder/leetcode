package leetcode;

/*
 * @author:石建雷
 * @data: 2018/11/17 20:59
 * @ClassName:Solution
 *
 *
 */
public class Solution {
    /**
     * 3. 统计数字
     * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
     * <p>
     * 样例
     * 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
     *
     * @param k
     * @param n
     * @return
     */

    public int digitCounts(int k, int n) {
        // write your code here
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCount(i, k);
            //1+
        }
        return cnt;
    }

    public int singleCount(int i, int k) {
        if (i == 0 && k == 0)
            return 1;
        int cnt = 0;
        while (i > 0) {
            if (i % 10 == k) {
                //2
                cnt++;
            }
            i = i / 10;
        }
        return cnt;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int num = solution.digitCounts(1, 12);

        System.out.println(num);


    }

}
