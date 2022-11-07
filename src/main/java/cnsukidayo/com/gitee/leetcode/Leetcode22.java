package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/7 18:11
 */
public class Leetcode22 {


    private List<String> result;

    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        char[] pre = new char[n * 2];
        pre[0] = '(';
        backTracking(n - 1, 1, pre, 1);
        return result;
    }

    private void backTracking(int leftCount, int rightCount, char[] pre, int index) {
        // 每次都面临两个选择,要么添加左括号要么添加右括号
        if (leftCount == 0) {
            for (int i = 0; i < rightCount; i++) {
                pre[index + i] = ')';
            }
            result.add(new String(pre));
        } else {
            char[] chars0 = Arrays.copyOf(pre, pre.length);
            chars0[index] = '(';
            backTracking(leftCount - 1, rightCount + 1, chars0, index + 1);
            if (rightCount > 0) {
                chars0[index] = ')';
                backTracking(leftCount, rightCount - 1, chars0, index + 1);
            }
        }
    }


}
