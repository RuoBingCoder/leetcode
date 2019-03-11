package lintcode;

/**
 * @author : 石建雷
 * @date :2019/1/17
 */

public class BinarySearch {

    public static int rank(int key, int[] a) {

        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int low, int height) {

        if (low > height) {
            return -1;
        }
        int mid = low + (height - low) / 2;
        if (key < a[mid]) {
            return rank(key, a, low, mid - 1);


        } else if (key > a[mid]) {

            return rank(key, a, mid + 1, height);
        } else {
            if (a[mid] == key) {

                while (mid - 1 >= 0 && a[mid - 1] == key) {
                    mid--;

                }


            }
            return mid;

        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,5,7,9,10,13};
        /*
         *  二分查找必须有序
         */

        System.out.println(BinarySearch.rank(3, a));

    }
}