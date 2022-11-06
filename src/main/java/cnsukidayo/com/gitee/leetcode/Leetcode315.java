package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/1 16:08
 */
public class Leetcode315 {
    private int[] result;
    private int[] index;

    public List<Integer> countSmaller(int[] nums) {
        this.result = new int[nums.length];
        this.index = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        split(nums, 0, nums.length - 1);
        List<Integer> answer = new ArrayList<>(nums.length);
        for (int i : result) {
            answer.add(i);
        }
        return answer;
    }

    private void split(int[] nums, int left, int right) {
        // 递归出口
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) >> 1;
        // 处理左区域
        split(nums, left, middle);
        // 处理右区域
        split(nums, middle + 1, right);
        // 合并区域并计算逆序对
        merge(nums, left, middle + 1, right);
    }

    private void merge(int[] nums, int left, int middle, int right) {
        int[] sort = new int[right - left + 1];
        int[] tempIndexArray = new int[right - left + 1];
        int sortIndex = 0;
        int leftStart = left;
        int middleStart = middle;
        while (leftStart < middle && middleStart <= right) {
            if (nums[leftStart] <= nums[middleStart]) {
                result[index[leftStart]] += middleStart - middle;
                tempIndexArray[sortIndex] = index[leftStart];
                sort[sortIndex++] = nums[leftStart++];
            } else {
                tempIndexArray[sortIndex] = index[middleStart];
                sort[sortIndex++] = nums[middleStart++];
            }
        }
        while (leftStart != middle) {
            tempIndexArray[sortIndex] = index[leftStart];
            result[index[leftStart]] += right - middle + 1;
            sort[sortIndex++] = nums[leftStart++];
        }
        while (middleStart <= right) {
            tempIndexArray[sortIndex] = index[middleStart];
            sort[sortIndex++] = nums[middleStart++];
        }
        while (right >= left) {
            index[right] = tempIndexArray[--sortIndex];
            nums[right--] = sort[sortIndex];
        }
    }

}
