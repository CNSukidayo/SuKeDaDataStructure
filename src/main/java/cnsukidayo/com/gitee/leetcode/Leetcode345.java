package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/8 10:26
 */
public class Leetcode345 {
public String reverseVowels(String s) {
    int left = 0;
    int right = s.length() - 1;
    char[] chars = s.toCharArray();
    while (left < right) {
        if (!(chars[left] == 'a' || chars[left] == 'e' || chars[left] == 'i' || chars[left] == 'o' || chars[left] == 'u' || chars[left] == 'A' || chars[left] == 'E' || chars[left] == 'I' || chars[left] == 'O' || chars[left] == 'U')) {
            left++;
            continue;
        }
        if (!(chars[right] == 'a' || chars[right] == 'e' || chars[right] == 'i' || chars[right] == 'o' || chars[right] == 'u' || chars[right] == 'A' || chars[right] == 'E' || chars[right] == 'I' || chars[right] == 'O' || chars[right] == 'U')) {
            right--;
            continue;
        }
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
    }
    return new String(chars);
}
}
