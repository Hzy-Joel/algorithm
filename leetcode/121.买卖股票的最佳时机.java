/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 * 
 * 
 * 状态转移方程
 * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
 * 
 * 
 * 当k = 1
 * 
 * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
 * dp[i][1] = max(dp[i-1][1],-prices[i])
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
// @lc code=end
