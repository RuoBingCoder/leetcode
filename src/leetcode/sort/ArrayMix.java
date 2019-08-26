package leetcode.sort;

import java.util.*;

/**
 * @author : 石建雷
 * @date :2019/8/20
 */

public class ArrayMix {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return nums1;
        }

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j])) {
                set.add(nums2[j]);
            }
        }

        int[] res = new int[set.size()];
        int k = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            res[k++] = (int) iterator.next();
        }
        return res;
    }

    /**
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayMix arrayMix = new ArrayMix();
        int[] one = {};
        int[] one1 = {1, 2, 2, 1};
        int[] two2 = {1};
        int[] two = {9, 4, 9, 8, 4};
        int[] intersection = arrayMix.intersection(two2, one);

        for (int i = 0; i < intersection.length; i++) {
            System.out.print(intersection[i] + ",");
        }

    }
}
