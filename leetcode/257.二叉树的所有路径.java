import java.util.ArrayList;
import java.util.List;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        travles(root, new StringBuilder());
        return ans;
    }

    public void travles(TreeNode root, StringBuilder path) {
        if (root == null)
            return;
        int pre = path.length();
        if (path.length() > 0) path.append("->" + root.val);
        else path.append(root.val);
        if (root.left == null && root.right == null)
            ans.add(path.toString());
        travles(root.left, path);
        travles(root.right, path);
        path.delete(pre, path.length());
    }
}
// @lc code=end
