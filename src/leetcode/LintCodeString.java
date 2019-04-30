package leetcode;

import java.util.*;

/**
 * @author : 石建雷
 * @date :2019/2/1
 */

public class LintCodeString {
    /**
     * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
     * <p>
     * 如果这个数被3整除，打印fizz.
     * 如果这个数被5整除，打印buzz.
     * 如果这个数能同时被3和5整除，打印fizz buzz.
     * 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
     *
     * @param ‘1’-N 任意数字
     * @return 一个集合
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("fizz buzz");

            } else if (i % 3 == 0) {
                list.add("fizz");
            } else if (i % 5 == 0) {
                list.add("buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LintCodeString lintCodeString = new LintCodeString();
        System.out.println(lintCodeString.fizzBuzz(15).toString());
    }

}
