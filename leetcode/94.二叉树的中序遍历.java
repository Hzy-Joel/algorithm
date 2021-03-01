import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        while(pre != null || !stack.isEmpty()){
            while(pre != null){
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

