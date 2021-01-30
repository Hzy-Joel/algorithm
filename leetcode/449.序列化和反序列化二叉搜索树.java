import java.util.LinkedList;
import java.util.Queue;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
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
            return "n#";
        String ans = root.val + "#";
        ans += serialize(root.left);
        ans += serialize(root.right);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataS = data.split("#");
        Queue<String> queue = new LinkedList<>();
        for (String string : dataS) {
            queue.add(string);
        }
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> data) {
        String ch = data.poll();
        if (ch.equals("n"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(ch));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
