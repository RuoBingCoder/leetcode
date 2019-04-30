package leetcode;

/**
 * @author : 石建雷
 * @date :2019/1/13
 * 丑数查找
 */

public class UglyNumber {

    private static int[] add;

    public int ugly(int index) {
        if (index < 0) {
            return 0;
        }

        add = new int[index];
        add[0] = 1;
        int number1 = 0;
        int number2 = 0;
        int number3 = 0;
        for (int i = 1; i < index; i++) {


            int min = min(add[number1] * 2, add[number2] * 3, add[number3] * 5);
            add[i] = min;
            while (add[number1] * 2 == add[i]) {
                number1++;
            }
            while (add[number2] * 3 == add[i]) {
                number2++;
            }
            while (add[number3] * 5 == add[i]) {
                number3++;
            }


        }

        return add[index - 1];
    }

    public int min(int number1, int number2, int number3) {

        int min = (number1 < number2) ? number1 : number2;
        return (min < number3) ? min : number3;


    }


    public static void main(String[] args) {

        UglyNumber uglyNumber = new UglyNumber();

        System.out.println(uglyNumber.ugly(2));
    }
}
