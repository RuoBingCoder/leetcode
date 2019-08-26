package leetcode.yanghuisanjiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/7/16
 * 杨辉三角
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */

public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] array = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {

            array[i][0] = 1;
        }
//            3

        for (int k = 0; k < numRows; k++) {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(array[k][0]);
            for (int j = 1; j <= k; j++) {
                array[k][j] = array[k - 1][j - 1] + array[k - 1][j];
                integerList.add(array[k][j]);
            }
            list.add(integerList);
        }

        return list;
    }

    public static void main(String[] args) {
        YangHuiTriangle yangHuiTriangle=new YangHuiTriangle();
        System.out.println(yangHuiTriangle.generate(5).toString());
    }
}
