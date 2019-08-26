package leetcode.bitopertion;

/**
 * @author : 石建雷
 * @date :2019/8/25
 */

public class BinaryAdd {

    public int getSum(int a, int b) {
        int sum = a;
        int carry = b;
        while (carry != 0) {
            int temp = sum;
            sum = temp ^ carry;
            carry = (temp & carry) << 1;
        }

        return sum;

    }

    public static void main(String[] args) {
        final BinaryAdd binaryAdd = new BinaryAdd();
        System.out.println(binaryAdd.getSum(0, 0));
    }
}
