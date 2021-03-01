/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                l1.next = cur;
                l1 = l1.next;
            } else {
                l2.next = cur;
                l2 = l2.next;
            }
            cur.next = null;
            cur = next;
        }
        l1.next = head2.next;
        return head1.next;
    }
}
// @lc code=end
