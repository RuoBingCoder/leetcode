package leetcode.array;

/**
 * @author : 石建雷
 * @date :2019/1/24
 */

public class ArrayMerge {
    /**
     * 合并两个有序的整数数组A和B变成一个新的数组。新数组也要有序
     *
     * @param A 数组A
     * @param B 数组B
     * @return 新数组
     */
    public int[] mergeSortedArray(int[] arrayOne, int[] arrayTwo) {
        int[] newArray = new int[arrayOne.length + arrayTwo.length];
        int temp = 0;
        int i = 0;
        int j = 0;
        MergeDeleteZeroArray.add(arrayTwo, temp, i, j, arrayOne, newArray);
        return newArray;
    }


    public static void main(String[] args) {
        int[] arrayListOne = {1, 2, 3, 4, 7, 8};
        int[] arrayListTwo = {2, 4, 5, 6};
        ArrayMerge arrayMerge = new ArrayMerge();
        int[] temp = arrayMerge.mergeSortedArray(arrayListOne, arrayListTwo);
        for (int number : temp) {
            System.out.print(number+" ");

        }
    }
}
