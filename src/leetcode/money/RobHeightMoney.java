package leetcode.money;

/**
 * @author : 石建雷
 * @date :2019/7/29
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 2,1,1,1,1,2
 * 2,3,3,3,3,3,4
 */

public class RobHeightMoney {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] array = new int[nums.length + 1];
        array[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            array[i] = Math.max(array[i - 1], array[i - 2] + nums[i - 1]);
        }

        return array[array.length - 1];
    }

    public static void main(String[] args) {
        RobHeightMoney robHeightMoney = new RobHeightMoney();
        int[] array = {2, 1, 1, 2};
        System.out.println(robHeightMoney.rob(array));
    }
}
