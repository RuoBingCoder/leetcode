package leetcode.tree;

/**
 * @author : 石建雷
 * @date :2019/7/15
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 *
 */

public class TreeHasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        System.out.println("第几次");
        System.out.println(root.val+"===="+sum);
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeHasPathSum treeHasPathSum=new TreeHasPathSum();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(8);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(12);
        System.out.println(treeHasPathSum.hasPathSum(node,13));
    }

}
