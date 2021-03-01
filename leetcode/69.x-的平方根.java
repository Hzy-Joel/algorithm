/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid > x)
                r = mid - 1;
            else {
                l = mid + 1;
                ans = mid;
            }

        }
        return ans;
    }
}
// @lc code=end
