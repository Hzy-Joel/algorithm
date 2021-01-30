/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 * 
 *  * 状态转移方程
 * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int dp1_0 = 0, dp1_1 = Integer.MIN_VALUE, dp2_0 = 0, dp2_1 = Integer.MIN_VALUE;
        for (int i : prices) {
            dp2_0 = Math.max(dp2_0, dp2_1 + i);
            dp2_1 = Math.max(dp2_1, dp1_0 - i);
            dp1_0 = Math.max(dp1_0, dp1_1 + i);
            dp1_1 = Math.max(dp1_1, -i);
        }
        return dp2_0;
    }
}
// @lc code=end
