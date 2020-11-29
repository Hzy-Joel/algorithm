
/***
 * 插入排序 思路： 1、从第二个数开始，在有序列表中向前比较，如果小于就交换，把有序列表往后推动，重复该操作直到所有数遍历完，时间复杂度O(n^2)
 */

public class InsertSort {
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j])
                    SortUtils.swap(nums, j - 1, j);
            }
        }
    }

}