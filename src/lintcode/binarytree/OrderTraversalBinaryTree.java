package lintcode.binarytree;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/2/3
 * 二叉树的中序非递归遍历
 */

public class OrderTraversalBinaryTree {
    private static Stack<TreeNode> stack;

    private List<Integer> traversalTree(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        stack = new Stack<>();
        if (node == null) {
            return list;
        }

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;

            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;

            }
        }
        return list;

    }


    public static void main(String[] args) {
        OrderTraversalBinaryTree tree = new OrderTraversalBinaryTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(tree.traversalTree(node).toString());
    }
}
