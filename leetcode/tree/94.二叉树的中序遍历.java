import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // public List<Integer> inorderTraversal(TreeNode root) {
    // List<Integer> ans = new ArrayList<>();
    // if(root == null) return ans;
    // Stack<TreeNode> stack = new Stack<TreeNode>();
    // HashSet<TreeNode> path = new HashSet<>();
    // stack.push(root);
    // path.add(root);
    // while (!stack.isEmpty()) {
    // TreeNode temp = stack.peek();
    // if (temp.left != null && !path.contains(temp.left)) {
    // stack.push(temp.left);
    // } else {
    // path.add(temp);
    // stack.pop();
    // ans.add(temp.val);
    // if (temp.right != null) stack.push(temp.right);
    // }

    // }
    // return ans;
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = root;
        while (pre != null || !stack.isEmpty()) {
            while(pre!=null){
                stack.push(pre);
                pre = pre.left;
            }
            pre = stack.pop();
            ans.add(pre.val);
            pre = pre.right;
        }
        return ans;
    }
}
// @lc code=end
