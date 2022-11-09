package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/9 13:35
 */
public class Leetcode78 {


    private List<List<Integer>> result;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        this.nums = nums;
        ArrayList<Integer> list = new ArrayList<>();
        result.add(list);
        for (int i = 1; i <= nums.length; i++) {
            backTracking(list, i, 0);
        }
        return result;
    }

    private void backTracking(List<Integer> append, int count, int index) {
        if (count == 0) {
            result.add(new ArrayList<>(append));
        } else {
            for (int i = index; this.nums.length - i >= count; i++) {
                append.add(nums[i]);
                backTracking(append, count - 1, i + 1);
                append.remove(append.size() - 1);
            }
        }
    }


}
