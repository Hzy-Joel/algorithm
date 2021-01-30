import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.AmbientLight;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *aabaab!bb
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0, left = 0;
        int ans = 0;
        HashSet<Character> path = new HashSet<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            boolean same = path.contains(ch);
            path.add(ch);
            right++;
            ans = Math.max(ans, path.size());
            while (same && s.charAt(left) != ch) {
                path.remove(s.charAt(left));
                left++;
            }
            if (same) left++;
        }
        return ans;
    }
}
// @lc code=end
