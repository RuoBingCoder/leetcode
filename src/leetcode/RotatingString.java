package leetcode;

/**
 * @author : 石建雷
 * @date :2019/1/27
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * 输入:  str="abcd efg", offset = 3
 * 输出: "efgabcd"
 */

public class RotatingString {
    private void rotateString(char[] str, int offset) {

       /* char[] str1 = new char[str.length];
        int j = 0;
        if (str.length == 0) {
            return;
        }
        for (int i = offset + 1; i < str.length; i++) {

            str1[j] = str[i];
            j++;

        }
        for (int k = 0; k <= offset; k++) {
            str1[j] = str[k];
            j++;


        }

*/
        if (str == null || str.length == 0)
            return;

        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
        /**
         * 先是abcd换成dcba ,在efg换成gfe,最后首位与尾部一一交换
         */
    }

    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }


    public static void main(String[] args) {
        String str = "abcdefg";
        RotatingString rotatingString = new RotatingString();
        rotatingString.rotateString(str.toCharArray(), 3);

//        Long startTime = System.currentTimeMillis();
        /*char[] str2 = rotatingString.rotateString(str.toCharArray(), 10);
        for (char c : str2) {
            System.out.print(c + " ");
        }
        System.out.println();
        Long endTime = System.currentTimeMillis();
        Long time = endTime - startTime;
        System.out.println(time + ":ms");*/
    }


}
