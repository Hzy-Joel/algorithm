import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // public boolean isSymmetric(TreeNode root) {
    // return isSymmetric(root, root);
    // }

    // private boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
    // if (leftRoot == null && rightRoot == null)
    // return true;
    // if (leftRoot == null || rightRoot == null)
    // return false;
    // return leftRoot.val == rightRoot.val
    // && isSymmetric(leftRoot.left, rightRoot.right)
    // && isSymmetric(leftRoot.right, rightRoot.left);
    // }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(leftRoot);
        queue.offer(rightRoot);
        while (!queue.isEmpty()) {
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            if (l == null && r == null) {
                continue;
            }
            if ((l == null || r == null) || (l.val != r.val)) {
                return false;
            }
            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        return true;
    }

}
// @lc code=end
