package leetcode.stack;

/**
 * @author : 石建雷
 * @date :2019/8/9
 */

public class BackSpaceCompareStr2 {

    public boolean backspaceCompare(String S, String T) {
        return compare(S).equals(compare(T));
    }

    public String compare(String str) {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '#') {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {

    }
}
