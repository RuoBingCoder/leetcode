package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/5/5
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * KMP算法
 */

public class StringIdentical {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
//        int num = haystack.indexOf(needle);

//        ab cc cd deee,cd

        /*int i = 0;
        int j = 0;
        int hay = haystack.length();
        int nd = needle.length();
        String[] hayStr = haystack.split("");
        String[] ndStr = needle.split("");
        while (i <= hay && j <= nd) {
            if (hayStr[i].equals(ndStr[j])) {
                i++;
                j++;
            }

        }*/
        int i = 0;
        int j = 0;
        int slen = haystack.length();
        int plen = needle.length();
        int[] next = new int[plen];
        getNext(needle, next);
        while (i < slen && j < plen) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

            } else if (next[j] == -1) {
                i++;
                j = 0;
            } else {
                /*
                 * 模式串：BBC ABCDAB ABCDABCDABDE
                 *  子串      ABCDABCD  的next[j]数组为：【-1，0，0，0，0，1，2，3】
                 *  h[10]!=nd[6] 因为 next[j]=2 所以只需将j=next[j] 和i++进行匹配
                 *
                 */
                j = next[j];
            }
            if (j == plen) {
                return i - j;
            }
        }
        return -1;

    }


    public static void getNext(String pattern, int[] next) {
        int j = 0;
        int k = -1;
        next[0] = -1;
        int len = pattern.length();
        while (j < len - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

    }

    public static void main(String[] args) {
        StringIdentical stringIdentical = new StringIdentical();
        int num = stringIdentical.strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABCD");
        System.out.println(num);
        List<Integer> integerList = Arrays.asList(1, 2, 4, 6, 8);
        integerList.forEach(System.out::println);

    }
}
