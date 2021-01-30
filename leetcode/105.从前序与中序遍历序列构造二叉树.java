import java.sql.RowId;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int il, int ir) {
        if (il > ir || i >= preorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[i]);
        int index = il;
        while (index < ir && inorder[index] != preorder[i]) {
            index++;
        }
        i++;
        TreeNode left = buildTree(preorder, inorder, il, index - 1);
        TreeNode right = buildTree(preorder, inorder, index + 1, ir);
        root.left = left;
        root.right = right;
        return root;
    }
}
// @lc code=end
