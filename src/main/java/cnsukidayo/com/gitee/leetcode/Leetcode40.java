package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/7 19:03
 */
public class Leetcode40 {

    private List<List<Integer>> result;
    private int target;
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        this.result = new ArrayList<>();
        this.candidates = candidates;
        backTracking(new ArrayList<>(), 0, 0);
        return result;
    }

    private void backTracking(List<Integer> append, int index, int preValue) {

        if (index > candidates.length) {
            return;
        }

        if (preValue == this.target) {
            this.result.add(new ArrayList<>(append));
        } else if (preValue < this.target) {
            for (int i = index; i < candidates.length; i++) {
                append.add(candidates[i]);
                backTracking(append, i, preValue + candidates[i]);
                append.remove(append.size() - 1);
            }
        }
    }


}
