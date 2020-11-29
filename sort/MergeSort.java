/***
 * 归并排序 思路： 1、将待排序数组按中间位置一分为二，排序好左右两个子列表再将其比较合并到一个数组中 2、子列表循环递归按照上面的排序方式排序
 * 3、按照递归方法、顺序是2->1，因此可以保证在合并时子列表已经排序好
 * 
 * 时间复杂度O(n^2)，空间复杂度O(n)
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] input = SortUtils.input(5, 5);
        SortUtils.printfArray(input);
        sort(input);
        SortUtils.printfArray(input);
    }

    public static void sort(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
    }

    public static void mergesort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergesort(nums, start, mid);
        mergesort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int i = 0;
        while (left < mid + 1 && right <= end) {
            temp[i++] = nums[left] > nums[right] ? nums[right++] : nums[left++];
        }
        while (left < mid + 1)
            temp[i++] = nums[left++];
        while (right <= end)
            temp[i++] = nums[right++];
        i = start;
        for (int j = 0; i <= end; i++, j++) {
            nums[i] = temp[j];
        }
    }

}