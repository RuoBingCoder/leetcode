package leetcode;

/**
 * @author : 石建雷
 * @date :2019/2/5
 */

public class SearchString {
    /**
     * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
     * 样例
     * 样例  1:
     * 输入: source = "source" ， target = "target"
     * 输出:-1
     * 样例解释:
     * 如果source里没有包含target的内容，返回-1
     * <p>
     * 样例 2:
     * 输入: source = "abcdabcdefg" ，target = "bcd"
     * 输出: 1
     * <p>
     * 样例解释:
     * 如果source里包含target的内容，返回target在source里第一次出现的位置
     */
    public int strStr(String source, String target) {
        int i = 0;
        int j = 0;
        char[] p = source.toCharArray();
        char[] q = target.toCharArray();
        int sourceLength = p.length;
        int targetLength = q.length;
        int[] next = new int[p.length];

        next[0] = -1;
        while (i < sourceLength && j < targetLength) {
            if (j == -1 || p[i] == q[j]) {
                i++;
                j++;

            } else {
                j = next[j];

            }

        }
        if (j == targetLength) {


            return i - j;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        SearchString string = new SearchString();
        String str1 = "substring searching";
        String str2 = "search";
        System.out.println(string.strStr(str1, str2));
    }
}
