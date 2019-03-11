package lintcode;

/**
 * @author 石建雷
 * @date 2018/11/15 22:17
 */
public class Two_sum {


    public int[] twosum(int[] numbers, int target) {

        int[] array = new int[2];
        for (int i = 0; i < numbers.length; i++) {

            int c = target - numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == c) {
                    array[0] = numbers[i];
                    array[1] = numbers[j];
                }

            }
        }
        return array;

    }


    public static void main(String[] args) {

        Two_sum two_sum = new Two_sum();
        int[] num = new int[]{2, 7, 11, 15};
        int tar = 9;
       System.out.println(two_sum.twosum(num, tar).toString());
        for (int i = 0; i <two_sum.twosum(num,tar).length ; i++) {

            System.out.println(two_sum.twosum(num,tar)[i]);

        }



    }

}
