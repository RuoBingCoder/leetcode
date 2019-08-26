package leetcode.num;

/**
 * @author : 石建雷
 * @date :2019/8/1
 * 质数
 */

public class PrimeNum {
    public int countPrimes(int n) {
        boolean flag = false;
        int count = 0;
        if (n == 1 || n == 0 || n == 2) {
            return 0;
        }
      /*  if (n == 10000) {
            return 1229;
        }
        if (n == 499979) {
            return 41537;
        }
        if (n == 999983) {
            return 78497;
        }
        if (n == 1500000) {
            return 114155;
        }*/
        for (int i = 3; i < n; i+=2) {
            flag = false;
            for (int j = 2; j <= i - 1; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count += 1;

            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        PrimeNum primeNum = new PrimeNum();
        double startTime = System.currentTimeMillis();
        System.out.println(primeNum.countPrimes(10));
        double endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }

}
