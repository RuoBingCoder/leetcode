package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/2/3
 * 递归中序遍历
 */

public class RecursiveOrderTraversalTree {
    private static List<Integer> list = new ArrayList<>();

    private List<Integer> preorderTraversalTree(TreeNode node) {

        if (node != null) {

            preorderTraversalTree(node.left);
            list.add(node.val);
            preorderTraversalTree(node.right);

        }
        return list;
    }

    public static void main(String[] args) {
        RecursiveOrderTraversalTree tree = new RecursiveOrderTraversalTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(tree.preorderTraversalTree(node).toString());
    }
}
