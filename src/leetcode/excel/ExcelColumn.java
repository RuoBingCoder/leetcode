package leetcode.excel;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author : 石建雷
 * @date :2019/7/21
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 */

public class ExcelColumn {
    public String convertToTitle(int n) {
        int last;
        StringBuilder builder = new StringBuilder();
        String[] str = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        while (n != 0) {
            last = n % 26;
            if (last == 0) {
                builder.append(str[25]);
                n = n - 26;
            } else {
                builder.append(str[last - 1]);

            }
            n = n / 26;
        }
        return builder.reverse().toString();

    }

    public static void main(String[] args) {
        ExcelColumn excelColumn = new ExcelColumn();
        System.out.println(excelColumn.convertToTitle(704));
        System.out.println(701 % 26);
        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("1", "张三");
        hashtable.put("2", "李四");
        for (Map.Entry entry : hashtable.entrySet()) {
            System.out.println(entry.getKey()+"==="+entry.getValue());

        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("1", 345);
        String s = "1";
        System.out.println(s.hashCode());
        System.out.println(s.hashCode() ^ (s.hashCode() >>> 16));
        System.out.println(s.hashCode() >>> 16);
        System.out.println(8>>>2);

    }
}
