import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> path = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (path.containsKey(target - nums[i]))
                return new int[] { i, path.get(target - nums[i]) };
            path.put(nums[i], i);
        }
        return new int[] { 0, 0 };
    }
}
// @lc code=end
