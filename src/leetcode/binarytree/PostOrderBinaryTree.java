package leetcode.binarytree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/2/3
 * 二叉树的后序遍历非递归算法
 */

public class PostOrderBinaryTree {
    private static Stack<TreeNode> stack;

    private List<Integer> traversalTree(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        stack = new Stack<>();
        TreeNode lastNode = node;
        // 游标当遍历的值等于lastNode时则说明已经遍历完成
        if (node == null) {
            return list;
        }
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastNode) {
                list.add(node.val);
                stack.pop();
                lastNode = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PostOrderBinaryTree tree = new PostOrderBinaryTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(tree.traversalTree(node).toString());
    }
}
