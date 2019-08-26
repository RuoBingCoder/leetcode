package leetcode.num;

import java.util.Arrays;

/**
 * @author : 石建雷
 * @date :2019/7/22
 * 众数
 * 2 2 2  3
 */

public class MoreNumbers {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        MoreNumbers moreNumbers = new MoreNumbers();
        int[] array = {3,2,3};
        System.out.println(moreNumbers.majorityElement(array));
    }
}
