public class HeapSort2 {

    public static void main(String[] args) {
        int[] input = SortUtils.input(5, 5);

        heapSort(input);
        SortUtils.printfArray(input);
    }

    public static int[] heapSort(int[] nums) {
        for (int i = (nums.length / 2) - 1; i >= 0; i--) {
            heapifity(nums, nums.length - 1, i);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapifity(nums, i - 1, 0);
        }
        return nums;
    }

    public static void heapifity(int[] nums, int len, int index) {
        while (index <= len) {
            int big = index * 2 + 1 <= len && nums[index] < nums[index * 2 + 1] ? index * 2 + 1 : index;
            big = index * 2 + 2 <= len && nums[big] < nums[index * 2 + 2] ? index * 2 + 2 : big;
            if (big == index)
                break;
            else {
                swap(nums, big, index);
                index = big;
            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}