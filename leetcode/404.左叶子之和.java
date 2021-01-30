import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int rs = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            rs += root.left.val;
        return rs + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}
// @lc code=end
