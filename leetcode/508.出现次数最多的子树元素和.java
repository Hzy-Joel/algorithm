import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private HashMap<Integer, Integer> path = new HashMap<>();
    private ArrayList<Integer> ans = new ArrayList<>();
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] rs = new int[ans.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = ans.get(i);
        }
        return rs;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int res = root.val;
        res += dfs(root.left);
        res += dfs(root.right);
        int times = path.getOrDefault(res, 1);
        path.put(res, times + 1);
        if (times > max) {
            max = times;
            ans.clear();
            ans.add(res);
        } else if (times == max) {
            ans.add(res);
        }
        return res;
    }
}
// @lc code=end
