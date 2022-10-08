package cnsukidayo.com.gitee.leetcode;

import java.util.Arrays;

/**
 * @author: sukidayo
 * @date: 2022/10/8 9:27
 */
public class Leetcode268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return nums[0] != 0 ? 0 : nums[nums.length - 1] + 1;
    }
}
