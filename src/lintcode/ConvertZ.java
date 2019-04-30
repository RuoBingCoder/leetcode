package lintcode;

/**
 * @author : 石建雷
 * @date :2019/3/29
 */

public class ConvertZ {

    private String convert(String s, int numRows) {
// 公差
        int tolerance = 2 * numRows - 2;

        if (numRows == 1 || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            for (int j = i; j < s.length(); j += tolerance) {

                sb.append(s.charAt(j));

                if (i != 0 && i != numRows - 1 && j + tolerance - 2 * i < s.length()) {

                    sb.append(s.charAt(j + tolerance - 2 * i));
                }

            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertZ convertZ = new ConvertZ();
        String s = "123456789";

        String convertStr = convertZ.convert(s, 3);

        System.out.println(convertStr);

    }
}
