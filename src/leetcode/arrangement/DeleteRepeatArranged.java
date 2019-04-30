package leetcode.arrangement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : 石建雷
 * @date :2019/2/7
 * 全排列去掉重复元素
 */

public class DeleteRepeatArranged {
    private static List<List<Integer>> arrange;
    private static List<Integer> arrangeList;
    private static List<List<Integer>> getArrange;
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
        Set<List<Integer>> set=new HashSet<>(arrange);
        getArrange=new ArrayList<>(set);

        return getArrange;
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
            prem(nums, from + 1, to);
            swap(nums, from, i);

        }

    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public static void main(String[] args) {
        FullyArranged arranged = new FullyArranged();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(arranged.permute(nums).toString());
    }
}
