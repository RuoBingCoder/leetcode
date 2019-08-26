package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/7
 * 反转二叉树
 */

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        InvertTree invertTree = new InvertTree();
        System.out.println(invertTree.getClass());
        List<Integer> list = new ArrayList();
        list.add(1);

        int i = 1;
        i = i++ + ++i;
        System.out.println(i);
    }
}
