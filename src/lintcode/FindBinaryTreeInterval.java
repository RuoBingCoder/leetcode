package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/2/1
 * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。
 * 即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值
 */

public class FindBinaryTreeInterval {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        if (root == null) {
            return list;
        }

        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        // 出队列

        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                continue;
            }
            if (k1 <= queue.get(i).val && queue.get(i).val <= k2) {
                list.add(queue.get(i).val);
            }


        }


        return list;
    }


    public static void main(String[] args) {
        FindBinaryTreeInterval treeInterval = new FindBinaryTreeInterval();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(treeInterval.searchRange(treeNode, 0, 4).toString());

    }
}
