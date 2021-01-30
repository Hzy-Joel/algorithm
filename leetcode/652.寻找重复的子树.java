import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private HashMap<String, Integer> path = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode root) {
        if (root == null)
            return "null";
        String str = root.val + "#" + dfs(root.left) + "#" + dfs(root.right);
        path.put(str, path.getOrDefault(str, 0)+1);
        if(path.get(str) == 2) ans.add(root);
        return str;
    }

}
// @lc code=end
