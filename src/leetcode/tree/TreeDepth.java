package leetcode.tree;

/**
 * @author : 石建雷
 * @date :2019/7/11
 * 二叉树的最大深度
 */

public class TreeDepth {

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
//        node.right = new TreeNode(2);
       /* node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);*/
        System.out.println(treeDepth.maxDepth(node));
    }

}
