import javafx.animation.FadeTransition;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    // ListNode ans = new ListNode(0);
    // ListNode pre = ans;
    // pre.next = head;
    // ListNode fast = head;
    // ListNode cur = head;
    // while (fast != null) {
    // if (n-- <= 0) {
    // pre = cur;
    // cur = cur.next;
    // }
    // fast = fast.next;
    // }
    // pre.next = cur.next;
    // return ans.next;
    // }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode pre = ans;
        ListNode cur = head;
        ListNode fast = head;
        while (fast != null) {
            if (n-- <= 0) {
                pre = cur;
                cur = cur.next;
            }
            fast = fast.next;
        }
        if (n > 0)  return head;
        pre.next = cur.next;
        return ans.next;
    }
}
// @lc code=end
