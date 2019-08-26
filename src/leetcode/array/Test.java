package leetcode.array;

/**
 * @author : 石建雷
 * @date :2019/7/8
 */

public class Test {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int k = m  - 1, i = m - 1, j = n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }
            if (j < 0) {
                nums1[k] = nums1[i--];
                continue;
            }

            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];
                m--;
            } else {
                nums1[k] = nums2[j--];
                n--;
            }
        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] array1 = {1, 2, 3, 0, 0, 0};
        int[] array2 = {2, 5, 6};
        test.merge(array1, 6, array2, 3);
    }
}
