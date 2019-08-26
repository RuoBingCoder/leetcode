package leetcode.sort;

/**
 * @author : 石建雷
 * @date :2019/6/12
 */

public class LastWordLen {
    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * <p>
     * 如果不存在最后一个单词，请返回 0 。
     * <p>
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: "Hello World"
     * 输出: 5
     * <p>
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        if (s.length() == 0) {
            return 0;
        }
        s = s.trim();
        char[] chars = s.toCharArray();
//        "Hello World"   "a  "
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (count > 0) {
                    break;
                }

            } else {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        LastWordLen len = new LastWordLen();
        String s = "a ";
//        String s = "  Hello World";
        long num = (1560347345000L - 1560347332491L)/1000L;
        System.out.println(num);
        System.out.println(len.lengthOfLastWord(s));
    }
}
