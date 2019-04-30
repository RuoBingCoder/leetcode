package leetcode.arrangement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/2/6
 * 全排列递归实现
 */

public class FullyArranged {
    private static List<List<Integer>> arrange;
    private static List<Integer> arrangeList;

    public List<List<Integer>> permute(int[] nums) {
        arrange = new ArrayList<>();
        if (nums == null) {
            return arrange;
        } else if (nums.length == 0) {
            arrange.add(new ArrayList<>());
            return arrange;
        } else {
            prem(nums, 0, nums.length - 1);
        }


        return arrange;
    }

    private static void prem(int[] nums, int from, int to) {
        if (from == to) {
            arrangeList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                arrangeList.add(nums[i]);

            }
            arrange.add(arrangeList);
        }

        for (int i = from; i <= to; i++) {
            swap(nums, from, i);
            // 交换数组第一个元素与后续的元素
            prem(nums, from + 1, to);
            // 后续元素递归全排列
            swap(nums, from, i);
            // 将交换后的数组还原

        }

    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public static void main(String[] args) {
        FullyArranged arranged = new FullyArranged();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(arranged.permute(nums).toString());
    }
}
