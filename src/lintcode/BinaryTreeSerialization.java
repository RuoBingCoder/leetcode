package lintcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : 石建雷
 * @date :2019/1/25
 * 二叉树的序列化与反序列化
 * 题目要求：对二进制树进行反序列化或序列化的方式没有限制，
 * LintCode将您的serialize输出作为deserialize的输入，它不会检查序列化的结果。
 */

public class BinaryTreeSerialization {

    private static Queue<TreeNode> queue = new LinkedList<>();
    private static Queue<TreeNode> queueData = new LinkedList<>();
    private StringBuilder builder = new StringBuilder();

    public String serialize(TreeNode root) {

        if (root == null) {
            return null;
        } else {
            queue.add(root);
            // 根节点不为空加入节点

//            "1,2,#,3,4,#";
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();

                if (treeNode == null) {
//                    str1 += "#,";
                    builder.append("#,");
                } else {
                    builder.append(treeNode.val+",");
                    queue.add(treeNode.left);
                    queue.add(treeNode.right);


                }
            }
//            builder.substring(0, builder.length() - 2);
        }

        return builder.toString();
    }


    /**
     * @param data 反序列化
     * @return String[] tree = {"3", "9", "20", "#", "#", "15", "7"};
     */
    public TreeNode deserialize(String data) {


        if ("#".equals(data) || data == null) {

            return null;

        } else {


            String[] value = data.split(",");

            TreeNode treeNode = new TreeNode(Integer.parseInt(value[0]));

            queueData.add(treeNode);
            int i = 1;
            while (!queueData.isEmpty() && i < value.length-1) {
                TreeNode node = queueData.poll();

                if ("#".equals(value[i])) {
                    node.left = null;

                    i++;


                } else {
                    treeNode.left = new TreeNode(Integer.parseInt(value[i]));
                    queueData.add(node.left);
                    i++;

                }
                if ("#".equals(value[i])) {
                    node.right = null;
                    i++;

                } else if (!"#".equals(value[i])) {
                    node.right = new TreeNode(Integer.parseInt(value[i]));
                    queueData.add(node.right);
                    i++;
                }
            }

            return treeNode;
        }
    }


    public static void main(String[] args) {

        String tree = "1,2,#,3,4,#";
        BinaryTreeSerialization serialization = new BinaryTreeSerialization();
        System.out.println(serialization.serialize(serialization.deserialize(tree)));


    }
}
