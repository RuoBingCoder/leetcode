package leetcode;

/**
 * @author : 石建雷
 * @date :2019/6/13
 */

public class OnePlus {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == 0 && digits[i] == 9) {
                digits[i] = 0;
                int[] newArray = new int[digits.length + 1];
                newArray[0] = 1;
                System.arraycopy(digits, 0, newArray, 1, digits.length);
                return newArray;
            }
            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        OnePlus plus = new OnePlus();
//        int[] array = {9, 9, 9, 9};
//        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 9};
        int[] array = {9};
        int[] array1 = plus.plusOne(array);
        for (int i : array1) {
            System.out.println(i);
        }
    }


}
