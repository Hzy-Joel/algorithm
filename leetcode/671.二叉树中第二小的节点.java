import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        return findSecondMinimumValue(root, root.val);
    }

    public int findSecondMinimumValue(TreeNode root, int pre) {
        if (root == null)
            return -1;
        if (root.val > pre) {
            return root.val;
        }
        int left = findSecondMinimumValue(root.left, root.val);
        int right = findSecondMinimumValue(root.right, root.val);
        if (left < 0)
            return right;
        if (right < 0)
            return left;
        return Math.min(left, right);
    }
}
// @lc code=end
