import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int ans = Integer.MAX_VALUE;
    private Integer pre;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        getMinimumDifference(root.left);
        if (pre != null) ans = Math.min(ans, Math.abs(pre - root.val));
        pre = root.val;
        getMinimumDifference(root.right);
        return ans;
    }
}
// @lc code=end
