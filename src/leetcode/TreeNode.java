package leetcode;

/**
 * @author : 石建雷
 * @date :2019/1/25
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right=null;

    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(2);
        System.out.println(treeNode.val);
    }
}
