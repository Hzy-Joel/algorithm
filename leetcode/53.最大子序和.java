/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            if (i == 0) ans = cur;
            else ans = Math.max(ans, cur);
        }
        return ans;
    }
}
// @lc code=end
