import leetcode.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

/*
 * @lc app=leetcode.cn id=623 lang=java
 *
 * [623] 在二叉树中增加一行
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null && d == 0)
            return new TreeNode(v);
        if (root == null)
            return null;
        TreeNode left;
        TreeNode right;
        if (d - 1 == 0) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        if (d - 1 == 1) {
            left = new TreeNode(v);
            right = new TreeNode(v);
            if (root.left != null) {
                left.left = root.left;
            }
            if (root.right != null) {
                right.right = root.right;
            }
        } else {
            left = addOneRow(root.left, v, d - 1);
            right = addOneRow(root.right, v, d - 1);
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
// @lc code=end
