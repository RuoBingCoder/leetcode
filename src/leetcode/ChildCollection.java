package leetcode;

import java.util.*;

/**
 * @author : 石建雷
 * @date :2019/2/9
 * 给定一个含不同整数的集合，返回其所有的子集
 * <p>
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 */

public class ChildCollection {
    private static List<List<Integer>> list1;
    private static List<Integer> list2;
    private static Set<List<Integer>> set;
    private static List<List<Integer>> inputList;

    public List<List<Integer>> subsets(int[] nums) {
        list1 = new ArrayList<>();
        Arrays.sort(nums);
        list2 = new ArrayList<>();
        int size = 1 << nums.length;
        for (int i = 1; i <= size; i++) {
            list2 = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    list2.add(nums[j]);
                }
            }
            list1.add(list2);

        }
        /**
         * 重复元素集合
         */
        set = new HashSet<>(list1);
        inputList = new ArrayList<>(set);
        return inputList;
    }

    /**
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     */
    public static void main(String[] args) {
        ChildCollection collection = new ChildCollection();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(collection.subsets(nums).toString());
    }
}
