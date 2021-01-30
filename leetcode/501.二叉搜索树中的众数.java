import java.util.ArrayList;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int max = 0;
    private ArrayList<Integer> ans = new ArrayList<>();
    private int preNum, num;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[] {};
        dfs(root);
        int[] rs = new int[ans.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = ans.get(i);
        }
        return rs;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (root.val == preNum)
            num++;
        else {
            num = 1;
            preNum = root.val;
        }
        if (num > max) {
            ans.clear();
            max = num;
            ans.add(root.val);
        } else if (num == max) {
            ans.add(root.val);
        } 
        dfs(root.right);
    }

}
// @lc code=end
