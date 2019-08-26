package leetcode.sort;

/**
 * @author : 石建雷
 * @date :2019/8/19
 */
@SuppressWarnings("all")
public class OddevenArraySort {
    //[4,1,1,0,1,0]   4,1,0,1,0,1,0

    //    [1,2,3,3,2,3,0,4]   2,1,2,3,
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int k = 0;
        int m = 1;
        int i = 0;
        int t = 2;
        while (i < A.length) {
            if (A[i] % 2 == 0) {
                result[k] = A[i++];
                k += 2;
            } else {
                result[m] = A[i++];
                m = 2 * t - 1;
                t++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        OddevenArraySort oddevenArraySort = new OddevenArraySort();
        int[] a = {4, 2, 5, 7};
        int[] a1 = {1, 2, 3, 3, 2, 3, 0, 4};
        int[] r = oddevenArraySort.sortArrayByParityII(a1);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }
}
