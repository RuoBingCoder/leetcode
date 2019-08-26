package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : 石建雷
 * @date :2019/8/5
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 */

public class ArrayHasRepeatNumTwo {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayHasRepeatNumTwo numTwo = new ArrayHasRepeatNumTwo();
        int[] array = {1, 2, 3, 1};
        int[] array1 = {1,0,1,1};
        int[] array2 = {99,99};

        System.out.println(numTwo.containsNearbyDuplicate(array1, 1));
    }
}
