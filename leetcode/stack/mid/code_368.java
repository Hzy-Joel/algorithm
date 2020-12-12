package leetcode.stack.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 368. 最大整除子集 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或
 * Sj % Si = 0。
 * 
 * 如果有多个目标子集，返回其中任何一个均可。
 * 
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3] 输出: [1,2] (当然, [1,3] 也正确) 示例 2:
 * 
 * 输入: [1,2,4,8] 输出: [1,2,4,8]
 * 
 * 
 * 给定升序序列（即 E < F < G）[E, F, G]，并且该列表本身满足问题中描述的整除子集，就不必枚举该子集的所有数字，在以下两种情况：
 * 
 *
 * 
 * 推论一：可除以整除子集中的最大元素的任何值，加入到子集中，可以形成另一个整除子集，即对于所有 h，若有 h % G == 0，则 [E, F, G, h]
 * 形成新的可除子集。
 * 
 * 推论二：可除以整除子集中最小元素的任何值，加入到子集中，可以形成另一个整除子集，即，对于所有的 d，若有 E % d == 0，则 [d, E, F,
 * G] 形成一个新的整除子集。
 * 
 * 上面两个推论可以帮助我们构造一个有效的解决方案。
 * 
 * 
 */
class code_368 {
    public static void main(String[] args) {
        List<Integer> rs = largestDivisibleSubset(new int[] { 1, 2, 4, 8 });
        for (Integer integer : rs) {
            System.out.println(integer + " ");
        }
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<Integer>();
        List<ArrayList<Integer>> dp = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ArrayList<Integer> maxSeq = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                ArrayList<Integer> last = dp.get(j);
                if (num % nums[j] == 0 && last.size() > maxSeq.size()) {
                    maxSeq = last;
                }
            }
            ArrayList<Integer> current = new ArrayList<>();
            current.addAll(maxSeq);
            current.add(num);
            dp.add(current);
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < dp.size(); ++i)
            if (ret.size() < dp.get(i).size())
                ret = dp.get(i);
        return ret;  //最后一个不一定是最终解
    }

    /***
     * 暴力解法 会超时
     */
    static List<Integer> rs;

    public static List<Integer> largestDivisibleSubse2(int[] nums) {
        rs = new ArrayList<>();
        DPS(nums, 0, new ArrayList<Integer>());
        return rs;
    }

    public static void DPS(int[] nums, int start, ArrayList<Integer> path) {
        if (start >= nums.length) {
            if (isTarget(path) && path.size() > rs.size()) {
                rs.clear();
                rs.addAll(path);
            }
            return;
        }
        path.add(nums[start]);
        if (isTarget(path) && path.size() > rs.size()) {
            rs.clear();
            rs.addAll(path);
        }
        DPS(nums, start + 1, path); // 带着自己的下一个值
        path.remove(path.size() - 1);
        DPS(nums, start + 1, path); // 不带着自己的下一个值
    }

    public static Boolean isTarget(ArrayList<Integer> nums) {
        for (Integer integer : nums) {
            for (Integer integer2 : nums) {
                if (integer % integer2 != 0 && integer2 % integer != 0)
                    return false;
            }
        }
        return true;
    }

}