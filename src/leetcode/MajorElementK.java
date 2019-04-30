package leetcode;

/**
 * @author : 石建雷
 * @date :2019/1/20
 * 主要用到计数排序
 */

public class MajorElementK {


    /**
     * @param num
     *
     * @return
     */
    public int sortNumber(int n, int[] num) {

        int min = num[0];
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }

        }
        for (int j = 1; j < num.length; j++) {
            if (num[j] > max) {
                max = num[j];
            }
        }
        int[] b = new int[num.length];
        int[] count = new int[max - min + 1];
        for (int i = min; i < max; i++) {
            count[max - min] = 0;
            // {9, 3, 2, 4, 8};
        }
        for (int i = 0; i < num.length; i++) {
            int temp = num[i];
            count[temp - min]++;
        }
        for (int i = min + 1; i <= max; i++) {
            count[i - min] = count[i - min - 1] + count[i - min];

        }
        for (int i = b.length - 1; i >= 0; i--) {
            b[count[num[i] - min] - 1] = num[i];

        }

        return b[b.length - n];

    }

    public static void main(String[] args) {
        int[] num = {9, 3, 5, 0, 2, 4, 8};
        MajorElementK majorElementK = new MajorElementK();
        Long startTime=System.currentTimeMillis();
        int num1 = majorElementK.sortNumber(2, num);
        Long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
        System.out.println(num1);


    }
}
