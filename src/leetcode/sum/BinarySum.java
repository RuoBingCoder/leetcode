package leetcode.sum;

/**
 * @author : 石建雷
 * @date :2019/7/5
 */

public class BinarySum {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int al = a.length() - 1;
        int bl = b.length() - 1;
        int carry = 0;

        while (al >= 0 || bl >= 0) {
            int sum = carry;
            if (al >= 0) {
                sum += (a.charAt(al)-'0');
                al--;
            }
            if (bl >= 0) {
                sum += (b.charAt(bl)-'0');
                bl--;
            }
            result.append(sum % 2);
            //相加结果
            carry = sum / 2;
            //进位，如果是1那么carry=0，如果是2则要进位给下面一位+1
        }

        if (carry != 0)
            //都相加完了，还要进位的情况
        {
            result.append(1);
        }

        return result.reverse().toString();
        //先反转，再输出
    }


    public static void main(String[] args) {
        BinarySum binarySum = new BinarySum();
        System.out.println(binarySum.addBinary("1001", "1111"));
    }
}
