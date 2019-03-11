package lintcode;

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
        while (i <= arrayOne.length - 1 && j <= arrayTwo.length - 1) {
            if (arrayOne[i] < arrayTwo[j]) {
                newArray[temp] = arrayOne[i];
                i++;
                temp++;
            } else if (arrayOne[i] == arrayTwo[j]) {
                newArray[temp] = arrayOne[i];
                newArray[++temp] = arrayTwo[j];
                i++;
                j++;
                temp++;
            } else {
                newArray[temp] = arrayTwo[j];
                j++;
                temp++;
            }

        }
        if (i < arrayOne.length) {
            for (int k = i; k < arrayOne.length; k++) {
                newArray[temp++] = arrayOne[k];
            }
        }
        if (j < arrayTwo.length) {
            for (int k = j; k < arrayTwo.length; k++) {
                newArray[temp++] = arrayTwo[k];

            }
        }
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
