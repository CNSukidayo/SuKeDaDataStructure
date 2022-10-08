package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/8 14:10
 */
public class Leetcode389 {
public char findTheDifference(String s, String t) {
    int[] compare = new int[26];
    for (int i = 0; i < s.length(); i++) {
        compare[s.charAt(i) - 97]++;
    }
    for (int i = 0; i < t.length(); i++) {
        if (--compare[t.charAt(i) - 97] < 0) {
            return t.charAt(i);
        }
    }
    return ' ';
}
}
