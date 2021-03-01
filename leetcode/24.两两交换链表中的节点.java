/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public ListNode swapPairs(ListNode head) {
    //     return swapKPairs(head, 2);
    // }

    // public ListNode swapKPairs(ListNode head, int k) {
    //     ListNode last = head;
    //     for (int i = 0; i < k; i++) {
    //         if (last == null)  return head;
    //         last = last.next;
    //     }
    //     ListNode ans = reversList(head, last);
    //     head.next = swapKPairs(last, k);
    //     return ans;
    // }

    // public ListNode reversList(ListNode head, ListNode last) {
    //     ListNode pre = null;
    //     ListNode cur = head;
    //     ListNode next = null;
    //     while (cur != last) {
    //         next = cur.next;
    //         cur.next = pre;
    //         pre = cur;
    //         cur = next;
    //     }
    //     return pre;
    // }


}
// @lc code=end
