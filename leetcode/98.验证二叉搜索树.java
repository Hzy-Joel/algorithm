import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return midTravel(root);
    }

    private Long pre = Long.MIN_VALUE;

    public boolean midTravel(TreeNode root) {
        if (root == null) return true;
        boolean ans = true;
        ans = midTravel(root.left);
        if (root.val <= pre || !ans) {
            return false;
        }
        pre = (long) root.val;
        ans = midTravel(root.right);
        return ans;
    }

}
// @lc code=end
