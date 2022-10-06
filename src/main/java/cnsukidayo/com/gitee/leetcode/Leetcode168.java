package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/6 19:01
 */
public class Leetcode168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber != 0) {
            int i = columnNumber % 26;
            columnNumber /= 26;
            if (i == 0) {
                stringBuilder.append('Z');
                columnNumber--;
            } else {
                stringBuilder.append((char) (64 + i));
            }
        }
        return stringBuilder.reverse().toString();
    }
}
