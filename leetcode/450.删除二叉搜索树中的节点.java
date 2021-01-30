import javax.management.remote.rmi.RMIIIOPServerImpl;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.left != null) {
                // 找左边最大的值
                TreeNode max = findMax(root.left);
                root.val = max.val;
                root.left = deleteNode(root.left, root.val);
            } else if (root.right != null) {
                // 找右边最小的值
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, root.val);

            } else {
                root =  null;
            }

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode findMax(TreeNode root) {
        if (root == null)
            return null;
        if (root != null && root.right == null)
            return root;
        else
            return findMax(root.right);
    }

    public TreeNode findMin(TreeNode root) {
        if (root == null)
            return null;
        if (root != null && root.left == null)
            return root;
        else
            return findMin(root.left);
    }
}
// @lc code=end
