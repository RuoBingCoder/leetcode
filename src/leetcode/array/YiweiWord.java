package leetcode.array;

import java.util.Arrays;

/**
 * @author : 石建雷
 * @date :2019/8/15
 */

public class YiweiWord {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.isEmpty() || t.isEmpty()) {
            return false;
        }
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        if (String.valueOf(char1).equals(String.valueOf(char2))) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * 输入: s = "anagram", t = "nagaram"
     * 1,
     * <p>
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * @param args
     */
    public static void main(String[] args) {
        YiweiWord word = new YiweiWord();
        String s1 = "abc";
        String s2 = "";
        System.out.println(s1.length());
        System.out.println(word.isAnagram(s1, s2));

        System.out.println(s1.charAt(1) - 'a');

        System.out.println(1 << 16);
        System.out.println("==========================================");
        String str = "anagram";

        char[] a = str.toCharArray();
        int[] count = new int[20];

       /* for (int i = -1; ++i <= 6;
             count[a[i]]++
        )
            ;
*/

        for (int i = 0, j = i; i < 6; j = ++i) {

            System.out.println(j + "***" + i);

        }
        /*for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }*/
    }
}
