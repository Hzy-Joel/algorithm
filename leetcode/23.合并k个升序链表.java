import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public ListNode mergeKLists(ListNode[] lists) {
    // ListNode ans = new ListNode(0);
    // ListNode cur = ans;
    // while(true){
    // int minIndex = 0;
    // ListNode minNode = null;
    // for (int i = 0; i < lists.length; i++) {
    // if(minNode == null){
    // minNode = lists[i];
    // minIndex = i;
    // continue;
    // }
    // if(lists[i]!=null && minNode.val > lists[i].val){
    // minNode = lists[i];
    // minIndex = i;
    // }
    // }
    // if(minNode == null) break;
    // cur.next = minNode;
    // cur = cur.next;
    // lists[minIndex] = lists[minIndex].next;
    // }
    // return ans.next;
    // }

    // public ListNode mergeKLists(ListNode[] lists) {
    // return mergeKLists(lists, 0, lists.length - 1);
    // }

    // public ListNode mergeKLists(ListNode[] lists, int start, int end) {
    // if (start == end)
    // return lists[start];
    // if (start > end)
    // return null;
    // int mid = (start + end) / 2;
    // return merge2List(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1,
    // end));
    // }

    // public ListNode merge2List(ListNode l1, ListNode l2) {
    // if (l1 == null)
    // return l2;
    // if (l2 == null)
    // return l1;
    // ListNode ans = l1.val < l2.val ? l1 : l2;
    // if (ans == l1)
    // l1 = l1.next;
    // else
    // l2 = l2.next;
    // ans.next = merge2List(l1, l2);
    // return ans;
    // }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        if (l > r)
            return null;
        int mid = (l + r) >> 1;
        return merge2List(mergeKLists(lists, l, mid), mergeKLists(lists, mid + 1, r));

    }

    public ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode ans = l1.val < l2.val ? l1 : l2;
        if (ans == l1)
            l1 = l1.next;
        if (ans == l2)
            l2 = l2.next;
        ans.next = merge2List(l1, l2);
        return ans;
    }

}
// @lc code=end
