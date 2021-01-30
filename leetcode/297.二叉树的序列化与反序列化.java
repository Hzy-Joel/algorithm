import java.util.LinkedList;
import java.util.Queue;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#_";
        String str = root.val + "_";
        return str + serialize(root.left) + serialize(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : nodes) {
            queue.add(s);
        }
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {

        if (queue == null || queue.isEmpty())

            return null;

        String str = queue.poll();

        if ("#".equals(str))

            return null;

        TreeNode root = new TreeNode(Integer.valueOf(str));

        root.left = buildTree(queue);

        root.right = buildTree(queue);

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
