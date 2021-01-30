import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        boolean ans = false;
        if (s.val == t.val)
            ans = compare(s, t);
        if (!ans)
            ans = isSubtree(s.left, t);
        if (!ans)
            ans = isSubtree(s.right, t);
        return ans;
    }

    public boolean compare(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return compare(s.left, t.left) && compare(s.right, t.right);
    }
}
// @lc code=end
