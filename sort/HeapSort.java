/***
 * 堆排序 思路： 1、数组构建大根堆，对于i节点,2i+1、2i+2节点是其左右孩子，3个节点调整大根堆（即最大数为父节点）
 * 对于n个数，只需要遍历其父节点，叶子节点不用考虑，因为在调整父节点时叶节点自然符合大根堆
 * 2、移出堆顶元素放入排序区，再重新构建大根堆，这次只需要根据大根堆性质调整树中的一半节点，花费的时间复杂度为o(n^2)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] input = SortUtils.input(5, 5);
        SortUtils.printfArray(input);
        sort(input);
        SortUtils.printfArray(input);
    }

    public static void sort(int[] nums) {
        // 构建大根堆
        for (int i = (nums.length) / 2 - 1; i >= 0; i--) {
            headfiy(nums, nums.length - 1, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            SortUtils.swap(nums, 0, i);
            headfiy(nums, i - 1, 0);
        }
    }

    /**
     * 
     * @param nums
     * @param len   堆大小
     * @param index 调整节点
     */
    public static void headfiy(int[] nums, int len, int index) {
        if (index < 0)
            return;
        while (index <= len) {
            int big = index;
            big = 2 * index + 1 <= len && nums[2 * index + 1] > nums[big] ? 2 * index + 1 : big;
            big = 2 * index + 2 <= len && nums[2 * index + 2] > nums[big] ? 2 * index + 2 : big;
            if (big != index) {
                SortUtils.swap(nums, index, big);
                index = big;
            } else
                break;
        }

    }

}