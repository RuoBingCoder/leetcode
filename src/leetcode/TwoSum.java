package leetcode;

/**
 * @author 石建雷
 * @date 2018/11/15 22:17
 * 给定一个整数数组，返回两个数字的索引，使它们相加到特定目标。
 * 您可以假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素
 */
public class TwoSum {


 private int[] twoSum(int[] numbers, int target) {

        int[] array = new int[2];
        for (int i = 0; i < numbers.length; i++) {

            int c = target - numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == c) {
                    array[0] = i;
                    array[1] = j;
                }

            }
        }
        return array;

    }


    public static void main(String[] args) {

        TwoSum two_sum = new TwoSum();
        int[] num = new int[]{3,3};
        int tar = 6;
        for (int i = 0; i <two_sum.twoSum(num,tar).length ; i++) {

            System.out.println(two_sum.twoSum(num,tar)[i]);

        }



    }

}
