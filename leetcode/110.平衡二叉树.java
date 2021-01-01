import java.util.HashSet;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dps(root) != -1;
    }

    public int dps(TreeNode root) {
        if (root == null)
            return 0;
        int left = dps(root.left);
        if (left == -1)
            return -1;
        int right = dps(root.right);
        return left == -1 || right == -1 || Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
// @lc code=end
