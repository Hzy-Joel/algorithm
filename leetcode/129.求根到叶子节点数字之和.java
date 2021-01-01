import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return ans;
        sumNumbers(root, 0);
        return ans;
    }

    private int ans = 0;

    public void sumNumbers(TreeNode root, int num) {
        if (root.left != null)
            sumNumbers(root.left, num * 10 + root.val);
        if (root.right != null)
            sumNumbers(root.right, num * 10 + root.val);
        if (root.left == null && root.right == null)
            ans += num * 10 + root.val;

    }
}
// @lc code=end
