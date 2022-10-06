package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/6 16:48
 */
public class Leetcode125 {
public boolean isPalindrome(String s) {
    char[] chars = s.toCharArray();
    int left = 0;
    int right = chars.length - 1;
    while (left < right) {
        // 如果不是26*2个字母+10个数字就跳过当前字符
        if (!((97 <= chars[left] && chars[left] <= 122) || (65 <= chars[left] && chars[left] <= 90) || (48 <= chars[left] && chars[left] <= 57))) {
            left++;
            continue;
        }
        if (!((97 <= chars[right] && chars[right] <= 122) || (65 <= chars[right] && chars[right] <= 90) || (48 <= chars[right] && chars[right] <= 57))) {
            right--;
            continue;
        }
        // 如果是数字就直接判相不相等
        if (((48 <= chars[left] && chars[left] <= 57) || (48 <= chars[right] && chars[right] <= 57)) && chars[left] != chars[right]) {
            return false;
        }
        if (!(chars[left] == chars[right] || chars[left] + 32 == chars[right] || chars[left] - 32 == chars[right])) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

}
