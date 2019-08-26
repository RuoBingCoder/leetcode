package leetcode.tree;

/**
 * @author : 石建雷
 * @date :2019/7/13
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

public class BalanceBinaryTreeIsTrue {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        if (!flag) {
            return false;
        }
        return true;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int max = Math.max(left, right);
        int min = Math.min(left, right);
        if ((max - min) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;

    }

    public static void main(String[] args) {
        BalanceBinaryTreeIsTrue isTrue = new BalanceBinaryTreeIsTrue();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);
        node.left.left.right = new TreeNode(7);
        System.out.println(isTrue.isBalanced(node));
    }

}
