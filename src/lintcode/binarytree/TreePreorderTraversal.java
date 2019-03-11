package lintcode.binarytree;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/2/2
 * 二叉树先序遍历采用非递归算法
 */

public class TreePreorderTraversal {
    private static List<Integer> list;
    private static Stack<TreeNode> stack;

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        stack = new Stack<>();
        if (root == null) {
            return list;

        }

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(stack.push(root).val);
                root = root.left;

            } else {

                root = stack.pop();
                //  访问栈顶元素，并删除栈顶元素
                root = root.right;
            }

        }

        return list;
    }

    public static void main(String[] args) {
        TreePreorderTraversal treePreorderTraversal = new TreePreorderTraversal();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(treePreorderTraversal.preorderTraversal(node).toString());
    }
}
