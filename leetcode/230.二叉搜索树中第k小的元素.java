import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        recur(root,k);
        return res;
    }
    
    public void recur(TreeNode node,int count) {
        if(node == null || count < 0) return;
        
        recur(node.left,count); 

        //操作
        --count;
        
        if(count == 0) {
            res = node.val;
            return;
        }

        recur(node.right,count);
    }
}
// @lc code=end

