package leetcode.sort;

/**
 * @author : 石建雷
 * @date :2019/8/18
 */

public class TwoArraySort {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] array = new int[1200];
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            array[arr1[i]]++;
        }

        int k = 0;
        for (int i = 0; i < arr2.length; i++) {

            while (array[arr2[i]] != 0) {
                result[k++] = arr2[i];
                array[arr2[i]]--;
            }


        }
        for (int i = 0; i < array.length; i++) {
            while (array[i] != 0) {
                result[k++] = i;
                array[i]--;

            }
        }


        return result;
    }

    /**
     * 1,2,2,2,3,3,4,6,7,9,19     0,0,0,0,0,0
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     *
     * @param args
     */
    public static void main(String[] args) {
        TwoArraySort twoArraySort = new TwoArraySort();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] temp = twoArraySort.relativeSortArray(arr1, arr2);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + ",");
        }

    }
}
