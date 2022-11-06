package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/5 10:23
 */
public class Leetcode17 {

    private List<String> result;
    char[][] chars = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        this.result = new ArrayList<>();
        int number = 0;
        for (char c : digits.toCharArray()) {
            number *= 10;
            number += c - 48;
        }
        if (number != 0) {
            backTracking(number, new char[digits.length()], 0);
        }
        return result;
    }


    private void backTracking(int number, char[] pre, int index) {
        if (number < 10) {
            for (int i = 0; i < chars[number - 2].length; i++) {
                pre[pre.length - index - 1] = chars[number - 2][i];
                result.add(new String(pre));
            }
        } else {
            // 得到末尾数
            int end = number % 10;
            for (int j = 0; j < chars[end - 2].length; j++) {
                char[] copy = Arrays.copyOf(pre, pre.length);
                copy[pre.length - index - 1] = chars[end - 2][j];
                backTracking(number / 10, copy, index + 1);
            }
        }
    }

}
