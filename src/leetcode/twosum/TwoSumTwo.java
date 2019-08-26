package leetcode.twosum;

/**
 * @author : 石建雷
 * @date :2019/7/21
 */

public class TwoSumTwo {
    private int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        int[] array = new int[2];
        int sum;
        while (i != j) {
            sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            }
            if (sum < target) {
                i++;
            }
            if (sum == target) {
                break;
            }
        }
        array[0] = i + 1;
        array[1] = j + 1;

        return array;

    }

    public static void main(String[] args) {
        TwoSumTwo twoSumTwo = new TwoSumTwo();
        int[] arrays = {2, 7, 8, 12, 9};
        int[] result = twoSumTwo.twoSum(arrays, 15);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}