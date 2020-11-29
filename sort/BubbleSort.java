
/***
 * 冒泡排序 思路：n 1、从头到尾两两对比，每一次将最大的值冒泡到尾部、时间复杂度O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] input = SortUtils.input(5, 5);
        sort(input);
        SortUtils.printfArray(input);
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortUtils.swap(nums, j, j + 1);
                }
            }
        }
    }

    
}
