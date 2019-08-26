package leetcode.array;

/**
 * @author : 石建雷
 * @date :2019/7/8
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */

public class MergeDeleteZeroArray2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArray = new int[m + n];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                tempArray[k++] = nums1[i++];
            } else {
                tempArray[k++] = nums2[j++];
            }
        }
        while (i < m) {
            tempArray[k++] = nums1[i++];
        }
        while (j < n) {
            tempArray[k++] = nums2[j++];
        }
        for (k = 0; k < (m + n); k++) {
            nums1[k] = tempArray[k];
        }
    }


    public static void main(String[] args) {
        MergeDeleteZeroArray2 mergeDeleteZeroArray = new MergeDeleteZeroArray2();
        int[] array1 = {1, 2, 3, 0, 0, 0};
        int[] array2 = {2, 5, 6};
        mergeDeleteZeroArray.merge(array1, 6, array2, 3);

    }
}
