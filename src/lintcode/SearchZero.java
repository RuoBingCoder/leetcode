package lintcode;

/**
 * @author : 石建雷
 * @date : 2019/1/7
 * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 */

public class SearchZero {

    private static final int NUMBER = 9;

    public int zero(int i, int k) {
        /*
         * iΪָ������
         * kΪ���ַ�Χ
         */

        int cout = 0;
        int j = 0;
        if (i == 0 && k <= NUMBER) {

            return 1;
        } else if (i == 0) {
            cout = 1;
            for (int m = 0; m <= k; m++) {
                j = m;
                while (j != 0) {


                    if (j % 10 == i) {
                        cout++;
                    }
                    j = j / 10;

                }
            }
        } else {
            for (int m = 0; m <= k; m++) {
                j = m;
                while (j != 0) {


                    if (j % 10 == i) {
                        cout++;
                    }
                    j = j / 10;

                }
            }
        }

        return cout;
    }


    public static void main(String[] args) {

        SearchZero zero = new SearchZero();
        int output = zero.zero(0, 20);
        System.out.println(output);
    }
}
