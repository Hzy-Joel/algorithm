import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickFind(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickFind(int[] nums, int left, int right, int k) {
        if (left > right)
            return -1;
        int mid = nums[left];
        int l = left;
        int r = right + 1;
        int i = left + 1;
        while (i < r) {
            if (nums[i] < mid) {
                swap(nums, i++, ++l);
            } else if (nums[i] > mid) {
                swap(nums, i, --r);
            } else {
                i++;
            }
        }
        swap(nums, left, r - 1);
        System.out.println();
        if (r - 1 == k) {
            return mid;
        } else if (r - 1 < k) {
            return quickFind(nums, r, right, k);
        } else {
            return quickFind(nums, left, r - 2, k);
        }

    }

    public void swap(int[] nums, int n, int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

}
// @lc code=end
