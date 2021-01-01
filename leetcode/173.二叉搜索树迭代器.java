import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.tree.TreeNode;
import sun.security.mscapi.KeyStore.ROOT;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode pre;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pre = root;
    }

    private TreeNode getLeft(TreeNode root) {
        if(!hasNext()) return null;
        while (root!= null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode temp = stack.pop();
        pre = temp.right;
        return temp;
    }

    public int next() {
        return getLeft(pre).val;
    }

    public boolean hasNext() {
        return pre != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
// @lc code=end
