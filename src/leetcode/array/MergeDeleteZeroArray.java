package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/7/8
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */

public class MergeDeleteZeroArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp = 0;
        int i;
        int m1 = 0;
        int n1 = 0;
        List<Integer> integerList = new ArrayList<>();
        for (i = 0; i < m; i++) {
            if (nums1[i] == 0) {
                continue;
            } else {
                integerList.add(nums1[i]);
            }
        }
        int[] arrayTemp = new int[integerList.size()];
        for (int k = 0; k < integerList.size(); k++) {
            arrayTemp[k] = integerList.get(k);
        }
        int[] newArray = new int[integerList.size() + n];
        if (nums2.length == 0) {
            newArray = arrayTemp;
        }
        add(nums2, temp, m1, n1, arrayTemp, newArray);

        for (int i1 : newArray) {
            System.out.println(i1);
        }
    }

    static void add(int[] nums2, int temp, int i, int j, int[] arrayTemp, int[] newArray) {
        while (i <= arrayTemp.length - 1 && j <= nums2.length - 1) {
            if (arrayTemp[i] < nums2[j]) {
                newArray[temp] = arrayTemp[i];
                i++;
                temp++;
            } else if (arrayTemp[i] == nums2[j]) {
                newArray[temp] = arrayTemp[i];
                newArray[++temp] = nums2[j];
                i++;
                j++;
                temp++;
            } else {
                newArray[temp] = nums2[j];
                j++;
                temp++;
            }

        }
        if (i < arrayTemp.length) {
            for (int k = i; k < arrayTemp.length; k++) {
                newArray[temp++] = arrayTemp[k];
            }
        }
        if (j < nums2.length) {
            for (int k = j; k < nums2.length; k++) {
                newArray[temp++] = nums2[k];
            }

        }
    }

    public static void main(String[] args) {
        MergeDeleteZeroArray mergeDeleteZeroArray = new MergeDeleteZeroArray();
        int[] array1 = {1, 2, 3, 0, 0, 0};
        int[] array2 = {2, 5, 6};
        mergeDeleteZeroArray.merge(array1, 6, array2, 3);

    }
}
