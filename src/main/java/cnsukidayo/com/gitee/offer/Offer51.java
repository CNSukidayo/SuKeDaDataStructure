package cnsukidayo.com.gitee.offer;

/**
 * @author: sukidayo
 * @date: 2022/11/1 13:27
 */
public class Offer51 {

    private int result;

    public int reversePairs(int[] nums) {
        split(nums, 0, nums.length - 1);
        return result;
    }

    private void split(int[] nums, int left, int right) {
        // 递归出口
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        // 处理左区域
        split(nums, left, middle);
        // 处理右区域
        split(nums, middle + 1, right);
        // 合并区域并计算逆序对
        merge(nums, left, middle + 1, right);
    }

    private void merge(int[] nums, int left, int middle, int right) {
        int[] sort = new int[right - left + 1];
        int sortIndex = 0;
        int leftStart = left;
        int middleStart = middle;
        while (leftStart < middle && middleStart <= right) {
            if (nums[leftStart] <= nums[middleStart]) {
                sort[sortIndex++] = nums[leftStart++];
            } else {
                result += middle - leftStart;
                sort[sortIndex++] = nums[middleStart++];
            }
        }
        while (leftStart != middle) {
            sort[sortIndex++] = nums[leftStart++];
        }
        while (middleStart <= right) {
            sort[sortIndex++] = nums[middleStart++];
        }
        while (right >= left) {
            nums[right--] = sort[--sortIndex];
        }
    }

}
