import java.util.HashMap;
import java.util.HashSet;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private HashSet<Integer> path = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        if (path.contains(k - root.val))
            return true;
        path.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
// @lc code=end
