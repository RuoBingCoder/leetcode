package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/14
 */

public class ArrayJiaoji {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length != 0) {
            return null;
        }
        if (nums2.length == 0 && nums1.length != 0) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                integerList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            res[i] = integerList.get(i);
        }
        return res;

    }

    /**
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayJiaoji jiaoji = new ArrayJiaoji();
        int[] num1 = {-2147483648, 1, 2, 3};
//        4,5,9
//        4,4,8,9,9 [-2147483648,1,2,3]
//[1,-2147483648,-2147483648]
        int[] num2 = {1, -2147483648, -2147483648};
        int[] s = jiaoji.intersect(num1, num2);
        for (int s1 : s) {
            System.out.println(s1);
        }
        int[] a = {};

    }
}
