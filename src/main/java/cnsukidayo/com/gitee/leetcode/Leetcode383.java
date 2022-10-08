package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/8 13:43
 */
public class Leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] compare = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            compare[magazine.charAt(i) - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--compare[ransomNote.charAt(i) - 97] < 0) {
                return false;
            }
        }
        return true;
    }
}
