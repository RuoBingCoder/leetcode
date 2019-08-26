package leetcode.tree;

/**
 * @author : 石建雷
 * @date :2019/7/14
 */

public class BinaryTreeMinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            int right = minDepth(root.right);
            return Math.max(0, right) + 1;
        } else if (root.left != null && root.right == null) {
            int left = minDepth(root.left);
            return Math.max(left, 0) + 1;
        } else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return Math.min(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        BinaryTreeMinDepth minDepth = new BinaryTreeMinDepth();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println(minDepth.minDepth(node));
    }
}
