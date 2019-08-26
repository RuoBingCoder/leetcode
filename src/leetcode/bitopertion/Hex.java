package leetcode.bitopertion;

/**
 * @author : 石建雷
 * @date :2019/8/23
 * 10进制转16进制
 */

public class Hex {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        long l = num;

        if (num < 0) {
            l = 4294967296L + l;
        }
        StringBuilder sb = new StringBuilder();
        String[] str = {"a", "b", "c", "d", "e", "f"};
        while (l != 0) {
            if (l % 16 > 9) {
                sb.append(str[(int) ((l % 16) - 10)]);
            } else {
                sb.append(l % 16);
            }
            l = l / 16;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Hex hex = new Hex();
        System.out.println(hex.toHex(-1));
    }
}
