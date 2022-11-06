package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/11/4 20:13
 */
public class Leetcode1863 {

    private int result;
    private int[] nums;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        for (int i = 1; i <= nums.length; i++) {
            backTracking(0, i, 0);
        }
        return result;
    }

    private void backTracking(int index, int size, int pre) {
        if (size == 1) {
            for (int i = index; i < nums.length; i++) {
                result += pre ^ nums[i];
            }
        } else {
            for (int i = index; i <= nums.length - size; i++) {
                backTracking(i + 1, size - 1, pre ^ nums[i]);
            }
        }

    }


}
