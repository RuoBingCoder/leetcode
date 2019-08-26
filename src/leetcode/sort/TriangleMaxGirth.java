package leetcode.sort;

import java.util.Arrays;

/**
 * @author : 石建雷
 * @date :2019/8/16
 */

public class TriangleMaxGirth {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i - 2] + A[i - 1] > A[i] && A[i - 2] + A[i] > A[i - 1] && A[i] + A[i - 1] > A[i - 2]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
            if (i - 2 == 0) {
                break;
            }
        }

        return 0;

    }

    /**
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * <p>
     * 如果不能形成任何面积不为零的三角形，返回 0。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[2,1,2]
     * 输出：5
     * 示例 2：
     * <p>
     * 输入：[1,2,1]
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：[3,2,3,4]
     * 输出：10
     * 示例 4：
     * <p>
     * 输入：[3,6,2,3]
     * 输出：8
     *
     * @param args
     */
    public static void main(String[] args) {
        TriangleMaxGirth maxGirth = new TriangleMaxGirth();
        int[] array = {3, 2, 3, 4};
        System.out.println(maxGirth.largestPerimeter(array));
    }
}
