package leetcode.tree;

/***
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * 
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 
 * 例如: 给定的树 A:
 * 
 *      3     / \    4   5   / \  1   2 给定的树 B：
 * 
 *    4    /  1 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 
 * 示例 1：
 * 
 * 输入：A = [1,2,3], B = [3,1] 输出：false 示例 2：
 * 
 * 输入：A = [3,4,5,1,2], B = [4,1] 输出：true
 * 
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return searchTree(A, B);
    }

    public Boolean searchTree(TreeNode root, TreeNode B) {
        if (root == null || B == null)
            return false;
        if (root.val == B.val && compareTree(root, B)) {
            return true;
        } else if (searchTree(root.left, B))
            return true;
        else
            return searchTree(root.right, B);
    }

    public Boolean compareTree(TreeNode A, TreeNode B) {
        if (A == null && B != null)
            return false;
        if (A == null && B == null || (A != null && B == null))
            return true;
        if (A.val == B.val) 
            return compareTree(A.left, B.left) && compareTree(A.right, B.right);
        else
            return false;
    }
}

