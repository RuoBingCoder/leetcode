package leetcode.zero;

/**
 * @author :石建雷
 * @date : 2018/11/16 22:08
 * 查找N的阶乘有多少个零
 */
public class FactorialZero {
    /**
     * 考虑到只要有5，或者因子为5的数，就可以产生0的尾部。假如1*2*3*4*...*250,
     * 那么250/5=50可以知道，有50个为5的倍数，但是里面有多少个为25的倍数，125的倍数...,
     *
     * @param n
     * @return
     */

    public long trailingZero(long n) {

        long sum = 0;
        while (n != 0) {

            sum += n / 5;

            n /= 5;

        }
        return sum;


    }


    public static void main(String[] args) {
        FactorialZero zero = new FactorialZero();
        Long startTime = System.currentTimeMillis();
        long c = zero.trailingZero(154);
        long endTime = System.currentTimeMillis();

        System.out.println(c);
        System.out.println(endTime - startTime + "ms");

    }

}
