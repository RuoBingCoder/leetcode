package leetcode.sum;

/**
 * @author : 石建雷
 * @date :2019/6/11
 */

public class MaxSequenceSum {
    /*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *示例:
     *输入: [-2,1,-3,4,-1,2,1,-5,4],
     *输出: 6
     *解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int max_num = nums[0];
        for (int num : nums) {
            sum = sum + num;
            if (num == 0 && sum < 0) {
                sum = 0;
            }
            if (sum > max_num) {
                max_num = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max_num;

    }


    public static void main(String[] args) {
        MaxSequenceSum sum = new MaxSequenceSum();
//        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] array = {-3, -2, 0, -1};
//        int[] array = {-3, -2, -1};
//        int[] array = {-3, -2, -1};
        int[] array = {-3, -2, 1, 2, 2, 0, 1, 0};
        System.out.println(sum.maxSubArray(array));
    }
}
