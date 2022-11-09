package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/8 15:57
 */
public class Leetcode77 {

    private List<List<Integer>> result;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        this.result = new ArrayList<>();
        this.n = n;
        backTracking(1, k, new ArrayList<>());
        return result;
    }

    private void backTracking(int index, int k, List<Integer> append) {
        if (k == 1) {
            for (int i = index; i <= this.n; i++) {
                append.add(i);
                this.result.add(new ArrayList<>(append));
                append.remove(append.size() - 1);
            }
        } else {
            // this.n - i + 1 >= k 这一步很关键
            for (int i = index; this.n - i + 1 >= k; i++) {
                append.add(i);
                backTracking(i + 1, k - 1, append);
                append.remove(append.size() - 1);
            }
        }
    }

}
