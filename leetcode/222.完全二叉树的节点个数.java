import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftHigh = getHigh(root.left);
        int rightHigh = getHigh(root.right);
        if (leftHigh > rightHigh) {
            return (int) Math.pow(2, rightHigh) + countNodes(root.left);
        } else {
            return (int) Math.pow(2, leftHigh) + countNodes(root.right);
        }
    }

    public int getHigh(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHigh(root.left), getHigh(root.right)) + 1;
    }
}
// @lc code=end
