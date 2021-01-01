import java.util.ArrayList;
import java.util.List;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root,sum,new ArrayList<>());
        return ans;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            ans.add(new ArrayList<>(path));
        }
        pathSum(root.left, sum - root.val, path);
        pathSum(root.right, sum - root.val, path);
        path.remove(path.size()-1);
    }
}
// @lc code=end
