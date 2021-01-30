import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        TreeNode right = trimBST(root.right, low, high);
        if (root.val < low)
            return right;
        TreeNode left = trimBST(root.left, low, high);
        if (root.val > high)
            return left;
        root.left = left;
        root.right = right;
        return root;
    }
}
// @lc code=end
