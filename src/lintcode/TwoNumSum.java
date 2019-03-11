package lintcode;

/*
 * @author:石建雷
 * @data: 2018/11/16 21:34
 * @ClassName:TwoNum_sum
 */
public class TwoNumSum {
    /**
     * @param a
     * @param b
     * @return 两数相加，第一步：先进行&运算，不进位，第二步：在进行进位运算，
     * 第三步：进行第一步和第二步相加；
     */

    public int add(int a, int b) {
        /**
         * 迭代相加算法
         *
         */
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        /*
         * 位异或( ^ )
         * 5 二进制：101
         * 7 二进制：111
         * 进行或  ：010
         * */
        int carry = (a & b) << 1;

        /*
         * 位与( & )
         * 5 二进制：101
         * 7 二进制：111
         * 进行与  ：101
         *
         * */
        return add(sum, carry);

    }

    public static void main(String[] args) {

        TwoNumSum sum = new TwoNumSum();
        int sum_1 = sum.add(5, 7);
        System.out.println(sum_1);


    }

}
