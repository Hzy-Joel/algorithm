/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 *  * 状态转移方程
 * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, temp - prices[i]);
        }
        return dp_0;
    }
}
// @lc code=end
