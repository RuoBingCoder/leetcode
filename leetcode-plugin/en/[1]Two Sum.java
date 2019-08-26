//
//给定一个整数数组，返回两个数字的索引，使它们相加到特定目标。 //
////您可以假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
//
// 
//

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ayyay = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i; j < nums.length; j++) {
                if (temp = nums[j]) {
                    ayyay[0] = i;
                    ayyay[1] = j;
                }

            }
        }

        return ayyay;
    }

}