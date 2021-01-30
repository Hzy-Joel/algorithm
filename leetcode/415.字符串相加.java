/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int l = num1.length() - 1, r = num2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (l >= 0 || r >= 0) {
            int n1 = l >= 0 ? num1.charAt(l) - '0' : 0;
            int n2 = r >= 0 ? num2.charAt(r) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            ans.append(sum % 10);
            l--;
            r--;
        }
        if (carry > 0) ans.append(carry);
        return ans.reverse().toString();
    }
}
// @lc code=end
