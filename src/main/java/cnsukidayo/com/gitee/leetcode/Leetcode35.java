package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/6 12:58
 */
public class Leetcode35 {
public int searchInsert(int[] nums, int target) {
    return searchInsert(nums, target, 0, nums.length - 1);
}

public int searchInsert(int[] nums, int target, int left, int right) {
    int mid = (right - left) / 2 + left;
    if (nums[mid] == target) {
        return mid;
    }
    if (mid == left) {
        if (target < nums[left]) {
            return left;
        } else if (target > nums[right]) {
            return right + 1;
        } else {
            return left + 1;
        }
    }
    if (nums[mid] > target) {
        return searchInsert(nums, target, left, mid);
    } else if (nums[mid] < target) {
        return searchInsert(nums, target, mid, right);
    }
    return right;
}

}
