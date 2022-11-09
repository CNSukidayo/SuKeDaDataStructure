package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/8 14:58
 */
public class Leetcode46 {
    private List<List<Integer>> result;
    private List<Integer> nums;

    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        this.nums = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            this.nums.add(nums[i]);
        }
        backTracking(new ArrayList<>(nums.length));
        return result;
    }

    private void backTracking(List<Integer> append) {
        // 递归出口
        if (this.nums.size() == 0) {
            result.add(new ArrayList<>(append));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                Integer remove = nums.remove(i);
                append.add(remove);
                backTracking(append);
                append.remove(append.size() - 1);
                nums.add(i, remove);
            }
        }
    }
}
