
/****
 * 普通快排 思路： 1、选取第一个数作为分割线，将小于的数放置在其左边、大于的数放置在其右边，等于的数在中间 2、递归快排左右两侧直到左右指针相等
 * 分析：在最好情况下，每次选取的第一个数都是此次排序的中间值，使得剩余的子问题规模均分呈平衡二叉树分布，则花费的时间复杂度为O(nlogn)
 * 但在最坏的情况下(即每次的第一个数都是最大或最小数)会退化成O(n^2)，优化方式是每次随机从排序数据中拿取一个数作为划分点，使得时间复杂度趋于平均值
 * 
 * 
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] input = SortUtils.input(5, 5);
        SortUtils.printfArray(input);
        sort(input);
        SortUtils.printfArray(input);
    }

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int num = nums[start];
        int small = start - 1;
        int big = end + 1;
        for (int i = start; i <= end && small < big && i < big; i++) {
            if (nums[i] < num) {
                SortUtils.swap(nums, i, ++small);
            } else if (nums[i] > num) {
                SortUtils.swap(nums, i, --big);
                i--;
            }
        }
        quickSort(nums, start, small);
        quickSort(nums, big, end);
    }
}