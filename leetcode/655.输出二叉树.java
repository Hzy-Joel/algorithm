import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<List<String>> ret = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return ret;
        }
        int totalDepth = depth(root);
        int size = (int) Math.pow(2, totalDepth) - 1;
        String[] treeArray = new String[size];
        Arrays.fill(treeArray, "");
        for (int i = 0; i < totalDepth; i++) {
            ret.add(new ArrayList<>(Arrays.asList(treeArray)));
        }
        handle(root, 0, size - 1, 0);
        return ret;
    }

    private void handle(TreeNode root, int start, int end, int dep) {
        if (root == null || start > end) {
            return;
        }
        int index = start + (end - start) / 2;
        List<String> strings = ret.get(dep);
        strings.set(index, Integer.toString(root.val));

        handle(root.left, start, index - 1, dep + 1);
        handle(root.right, index + 1, end, dep + 1);

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = root.left != null ? depth(root.left) + 1 : 1;
        int right = root.right != null ? depth(root.right) + 1 : 1;
        return Math.max(left, right);
    }
}
// @lc code=end
