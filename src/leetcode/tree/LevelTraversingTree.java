package leetcode.tree;

import java.util.*;

/**
 * @author : 石建雷
 * @date :2019/7/11
 * 层次遍历二叉树
 */

public class LevelTraversingTree {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        TreeNode treeNode;
        if (root == null) {
            return listList;
        }
        LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
        int size;
        treeNodeQueue.add(root);
        size = treeNodeQueue.size();
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                treeNode = treeNodeQueue.pop();
                if (treeNode.left != null) {
                    treeNodeQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.add(treeNode.right);
                }
                integerList.add(treeNode.val);
            }
            listList.add(integerList);
            size = treeNodeQueue.size();

        }
        Collections.reverse(listList);
        return listList;
    }

    public static void main(String[] args) {
        LevelTraversingTree levelTraversingTree = new LevelTraversingTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        List<List<Integer>> listList = levelTraversingTree.levelOrderBottom(node);
        System.out.println(listList.toString());
    }

}
