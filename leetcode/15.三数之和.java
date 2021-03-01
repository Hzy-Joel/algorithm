import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {

    // public List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> ans = new ArrayList<>();
    // Arrays.sort(nums);
    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] > 0) break;
    // if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
    // int left = i + 1, right = nums.length - 1;
    // while (left < right) {
    // int sum = nums[left] + nums[right] + nums[i];
    // if (sum == 0) {
    // List<Integer> temp = new ArrayList<>();
    // temp.add(nums[i]);
    // temp.add(nums[left]);
    // temp.add(nums[right]);
    // ans.add(temp);
    // while (left < right && nums[left] == nums[left + 1]) left++;
    // while (left < right && nums[right] == nums[right - 1]) right--;
    // right--;
    // left++;
    // } else if (sum > 0) {
    // right--;
    // } else {
    // left++;
    // }
    // }

    // }
    // return ans;
    // }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        Arrays.sort(nums);
        int pre = nums[0] - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (pre == nums[i])
                continue;
            pre = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (r > l) {
                if (nums[l] + nums[r] == -nums[i]) {
                    List<Integer> row = new ArrayList<>();
                    row.add(nums[l]);
                    row.add(nums[r]);
                    row.add(nums[i]);
                    ans.add(row);
                    int prel = nums[l];
                    int prer = nums[r];
                    while (l < nums.length && nums[l] == prel) l++;
                    while (r >= 0 && nums[r] == prer)  r--;
                } else if (nums[l] + nums[r] > -nums[i]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

}
// @lc code=end
