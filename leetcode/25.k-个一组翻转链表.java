/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int t = k;
        while (t-- > 0) {
            if (node == null) return head;
            node = node.next;
        }
        ListNode pre = reverse(head, node);
        ListNode last = reverseKGroup(node, k);
        head.next = last;
        return pre;
    }

    public ListNode reverse(ListNode head, ListNode node) {
        if (head == null)
            return null;
        ListNode pre = head;
        ListNode cur = head;
        ListNode next;
        while (cur != node) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
// @lc code=end
