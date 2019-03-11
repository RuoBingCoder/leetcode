package hello;

import lintcode.TreeNode;

import java.util.ArrayList;

/**
 * @author : 石建雷
 * @date :2019/2/2
 */

public class Demo02 {
    private ArrayList<Integer> results;
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in increasing order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        results = new ArrayList<Integer>();
        helper(root, k1, k2);
        return results;
    }

    private void helper(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            helper(root.left, k1, k2);
        }
        if (root.val >= k1 && root.val <= k2) {
            results.add(root.val);
        }
        if (root.val < k2) {
            helper(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        Demo02 demo02=new Demo02();
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(3);
        treeNode.right=new TreeNode(5);
        treeNode.left.left=new TreeNode(2);
        treeNode.left.right=new TreeNode(6);
        System.out.println(demo02.searchRange(treeNode,0,4).toString());
    }
}
