/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public ListNode deleteDuplicates(ListNode head) {
    // if (head == null || head.next == null) return head;
    // ListNode ans = head;
    // if(head.val == head.next.val){
    // while (ans.next != null && ans.val == ans.next.val) ans = ans.next;
    // ans = deleteDuplicates(ans.next);
    // } else ans.next = deleteDuplicates(head.next);
    // return ans;
    // }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val == head.next.val) {
            ListNode cur = head;
            while (cur != null && cur.val == head.val) cur = cur.next;
            return deleteDuplicates(cur);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

}
// @lc code=end
