package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/11/3 14:41
 */
public class Leetcode493 {

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
        // 排序
        while (leftStart < middle && middleStart <= right) {
            if (nums[leftStart] <= nums[middleStart]) {
                sort[sortIndex++] = nums[leftStart++];
            } else {
                sort[sortIndex++] = nums[middleStart++];
            }
        }
        while (leftStart != middle) {
            sort[sortIndex++] = nums[leftStart++];
        }
        while (middleStart <= right) {
            sort[sortIndex++] = nums[middleStart++];
        }
        // 计算结果  result += middle - leftStart;
        leftStart = left;
        middleStart = middle;
        while (leftStart < middle && middleStart <= right) {
            if (((long) nums[leftStart]) <= ((long) nums[middleStart] * 2)) {
                leftStart++;
            } else {
                result += middle - leftStart;
                middleStart++;
            }
        }
        while (right >= left) {
            nums[right--] = sort[--sortIndex];
        }
    }


}
