
/***
 * 选择排序： 思路：每次从未排序的数中选一个最大的数放到最后，将未排序区域-1，时间复杂度O(n^2)
 */
public class SelectionSort {
    public static void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int index = i;
            for (int j = 0; j <= i; j++) {
                index = nums[j] > nums[index] ? j : index;
            }
            //交换最大数到最后
            SortUtils.swap(nums, i, index);
        }
    }
}