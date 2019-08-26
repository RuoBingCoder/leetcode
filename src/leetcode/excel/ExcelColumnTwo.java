package leetcode.excel;

/**
 * @author : 石建雷
 * @date :2019/7/22
 * zy
 */

public class ExcelColumnTwo {
    public int titleToNumber(String s) {

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int k = s.charAt(i) - 65;
            result = (int) (result + (k + 1) * Math.pow(26, s.length()-i-1));
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelColumnTwo excelColumnTwo = new ExcelColumnTwo();
        String s = "AAA";
        System.out.println(excelColumnTwo.titleToNumber(s));
    }
}
