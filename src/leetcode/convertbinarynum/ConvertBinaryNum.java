package leetcode.convertbinarynum;

/**
 * @author : 石建雷
 * @date :2019/7/24
 */

public class ConvertBinaryNum {
    public int reverseBits(int n) {
        int result = Integer.reverse(n);
        return result;
    }

    public static void main(String[] args) {
        ConvertBinaryNum convertBinaryNum = new ConvertBinaryNum();
        System.out.println(convertBinaryNum.reverseBits(3));
//         964176192
        System.out.println(Integer.reverse(43261596));
    }
}
