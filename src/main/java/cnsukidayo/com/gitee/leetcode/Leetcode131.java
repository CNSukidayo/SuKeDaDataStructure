package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/9 16:12
 */
public class Leetcode131 {

    private List<List<String>> result;
    private char[] words;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        this.words = s.toCharArray();
        for (int i = 0; i < words.length; i++) {
            backTracking(new ArrayList<>(), i, 0);
        }
        return result;
    }

    private void backTracking(List<String> append, int splitCount, int index) {
        if (splitCount == 0) {
            if (judge(index, words.length - 1)) {
                append.add(new String(words, index, words.length - index));
                this.result.add(new ArrayList<>(append));
                append.remove(append.size() - 1);
            }
        } else {
            for (int i = index; i < words.length - splitCount; i++) {
                if (judge(index, i)) {
                    append.add(new String(words, index, i - index + 1));
                    backTracking(append, splitCount - 1, i + 1);
                    append.remove(append.size() - 1);
                }
            }
        }
    }

    private boolean judge(int start, int end) {
        while (start < end) {
            if (words[start] != words[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
