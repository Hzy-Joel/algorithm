/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    // private int ans = 1;
    // public int lengthOfLIS(int[] nums) {
    // if(nums.length == 0) return 0;
    // lengthOfLIS(nums, 0, 1);
    // return ans;
    // }

    // public void lengthOfLIS(int[] nums, int index, int num) {

    // if (index >= nums.length) return;
    // for (int i = index + 1; i < nums.length; i++) {
    // if (nums[i] > nums[index]) {
    // ans = Math.max(ans, num + 1);
    // lengthOfLIS(nums, i, num + 1);
    // } else lengthOfLIS(nums, i, 1);
    // }
    // }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int dp[] = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) { 
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }
}
// @lc code=end
