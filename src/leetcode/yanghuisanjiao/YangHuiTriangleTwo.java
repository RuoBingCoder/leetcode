package leetcode.yanghuisanjiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/7/17
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * [1,1]
 * [1,2,1]
 * 输出: [1,3,3,1]
 */

public class YangHuiTriangleTwo {
    public List<Integer> getRow(int rowIndex) {

//            3

        List<Integer> integerList = new ArrayList<>();

        int current = 1;
        for (int j = 0; j <= rowIndex; j++) {
            integerList.add(current);
            current = current * (rowIndex - j) / (j + 1);

        }


        return integerList;
    }

    public static void main(String[] args) {
        YangHuiTriangleTwo yangHuiTriangleTwo = new YangHuiTriangleTwo();
        System.out.println(yangHuiTriangleTwo.getRow(3));

    }
}
