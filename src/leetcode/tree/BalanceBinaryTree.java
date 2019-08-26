package leetcode.tree;

/**
 * @author : 石建雷
 * @date :2019/7/12
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */

public class BalanceBinaryTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertBST(nums, 0, nums.length - 1);
    }

    public TreeNode convertBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = convertBST(nums, left, mid - 1);
        treeNode.right = convertBST(nums, mid + 1, right);
        return treeNode;
//[-10,-3,0,5,9]
    }
}
