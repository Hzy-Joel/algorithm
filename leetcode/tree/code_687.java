package leetcode.tree;

/***
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 
 * 示例 1:
 * 
 * 输入: 5 / \ 4 5 / \ \ 1 1 5
 * 
 * 
 * 2 示例 2:
 * 
 * 输入:
 * 
 * 1 / \ 4 5 / \ \ 4 4 5
 * 
 * 2 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class code_687 {
    private int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        findDepth(root);
        return ans;
    }

    public int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft += leftDepth + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight += rightDepth + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}