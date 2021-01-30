import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.tree.TreeNode;
import sun.security.mscapi.KeyStore.ROOT;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int ans = 1;
    private HashMap<Integer, Integer> path = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        widthOfBinaryTree(root, 0, 0);
        return ans;
    }

    public void widthOfBinaryTree(TreeNode root, int depth, int index) {
        if(root == null) return;
        if (path.containsKey(depth)) {
            ans = Math.max(index - path.getOrDefault(depth, 0) + 1, ans);
        } else {
            path.put(depth, index);
        }
        widthOfBinaryTree(root.left, depth + 1, index * 2 + 1);
        widthOfBinaryTree(root.right, depth + 1, index * 2 + 2);
    }

}
// @lc code=end
