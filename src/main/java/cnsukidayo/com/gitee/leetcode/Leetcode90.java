package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/9 14:27
 */
public class Leetcode90 {

    private List<List<Integer>> result;
    private int[] nums;


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.result = new ArrayList<>();
        this.nums = nums;
        ArrayList<Integer> list = new ArrayList<>();
        result.add(list);
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            backTracking(list, i, 0);
        }
        return result;
    }

    private void backTracking(List<Integer> append, int count, int index) {
        if (count == 0) {
            result.add(new ArrayList<>(append));
        } else {
            int continueValue = Integer.MIN_VALUE;
            for (int i = index; this.nums.length - i >= count; i++) {
                if (continueValue == nums[i]) {
                    continue;
                }
                continueValue = nums[i];
                append.add(nums[i]);
                backTracking(append, count - 1, i + 1);
                append.remove(append.size() - 1);
            }
        }
    }


}
