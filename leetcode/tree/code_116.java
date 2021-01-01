package leetcode.tree;

import java.util.LinkedList;

import sun.reflect.generics.tree.Tree;

/**
 * 116. 填充每个节点的下一个右侧节点指针 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * 
 * struct Node { int val; Node *left; Node *right; Node *next; } 填充它的每个 next
 * 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 
 * 
 * 进阶：
 * 
 * 你只能使用常量级额外空间。 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 
 * 示例： right 输入：root = [1,2,3,4,5,6,7] 输出：[1,#,2,3,#,4,5,6,7,#] 解释：给定二叉树如图 A
 * 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next
 * 指针连接，'#' 标志着每一层的结束。
 */
public class code_116 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        connect(root.left, root.right);
        return root;
    }

    public void connect(Node left, Node right) {
        if (left == null)
            return;
        left.next = right;
        connect(left.left, left.right);
        connect(left.right, right.left);
        connect(right.left, right.right);
    }

    public Node connect2(Node root) {
        if (root == null)
            return null;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int pre = queue.size();
            Node preNode = null;
            for (int i = 0; i < pre; i++) {
                Node cur = queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                if(preNode == null){
                    preNode = cur;
                    continue;
                } else {
                    preNode.next = cur;
                    preNode = cur;
                }
                
            }
        }
        return root;
    }


    public Node connect3(Node root) {
        if (root == null)
            return null;
        if(root.left !=null) root.left.next = root.right;
        if(root.next !=null && root.right!=null) root.right.next = root.next.left;
        connect3(root.left);
        connect3(root.right);
        return root;
    }

}