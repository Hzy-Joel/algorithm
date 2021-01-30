import java.util.HashMap;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private HashMap<Integer, Integer> preNums = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        preNums.put(0, 1);
        return pathSum(root, sum, 0);
    }

    public int pathSum(TreeNode root, int sum, int presum) {
        if (root == null)
            return 0;
        presum += root.val;
        int rs = preNums.getOrDefault(presum - sum, 0);
        preNums.put(presum, preNums.getOrDefault(presum, 0) + 1);
        rs += pathSum(root.left, sum, presum);
        rs += pathSum(root.right, sum, presum);
        preNums.put(presum, preNums.getOrDefault(presum, 0) - 1);
        return rs;
    }

}
// @lc code=end
