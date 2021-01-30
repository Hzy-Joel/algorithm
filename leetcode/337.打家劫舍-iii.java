import java.util.HashMap;
import java.util.Map;

import leetcode.tree.TreeNode;
import sun.security.mscapi.KeyStore.ROOT;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[] { root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1]) };
    }

}
// @lc code=end
