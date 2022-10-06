package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/6 19:43
 */
public class Leetcode171 {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int temp = 1;
        for (int i = columnTitle.length() - 1; i > -1; i--) {
            int value = columnTitle.charAt(i) - 64;
            value *= temp;
            result += value;
            temp *= 26;
        }
        return result;
    }
}
