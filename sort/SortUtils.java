
import java.util.Arrays;

/***
 * 排序比较器，用于快速验证排序算法的准确性
 */
public class SortUtils {
    private static boolean DEBUG = false;

    public static void main(final String[] args) {
        int i = 0;
        for (; i < 1000; i++) {
            final int[] nums = input(i, i);
            int[] correctRs = nums.clone();
            int[] sortRs = nums.clone();
            Arrays.sort(correctRs);
            sort(sortRs);
            if (Arrays.equals(correctRs, sortRs)) {
                if (DEBUG)
                    System.out.println("OK");
            } else {
                System.out.println("RE:");
                printfArray(nums);
                System.out.println("---FUCK---");
                System.out.println("correctRs:");
                printfArray(correctRs);
                System.out.println("sort:");
                printfArray(sortRs);
                break;
            }
        }
        if (i == 1000)   System.out.println("PERFECT");
    }

    /***
     * 
     * @param len 生成数组长度 0~lenght
     * @param max 数组中数字的最大值 0~max
     * @return 生成数组
     */
    public static int[] input(final int len, final int max) {
        // 随机数组长度 1~lenght
        final int length = (int) (Math.random() * (len + 1));
        final int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = (int) (Math.random() * max);
        }
        if (DEBUG) {
            System.out.println("生成");
            printfArray(nums);
        }
        return nums;
    }

    public static void printfArray(int[] nums) {
        for (final int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sort(int[] nums) {
        // 冒泡
        // BubbleSort.sort(nums);
        // 选择
        // SelectionSort.sort(nums);
        // 插入
        // InsertSort.sort(nums);
        // 快排
        // QuickSort.sort(nums);
        // 归并
        // MergeSort.sort(nums);
        //堆排
        HeapSort.sort(nums);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
