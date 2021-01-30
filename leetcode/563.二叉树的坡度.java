import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int ans = 0;

    public int findTilt(TreeNode root) {
        findSum(root);
        return ans;
    }

    public int findSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = findSum(root.left);
        int right = findSum(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }
}
// @lc code=end
