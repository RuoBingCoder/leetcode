package lintcode;

/**
 * @author : 石建雷
 * @date :2019/4/30
 * [14] 最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */

public class ZuiChangQianZhui {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";

        }
        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.length() == 0) {
                    return "";
                }

            }

        }
        return result;
    }


    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        ZuiChangQianZhui zhui = new ZuiChangQianZhui();
        System.out.println(zhui.longestCommonPrefix(str));

    }
}
