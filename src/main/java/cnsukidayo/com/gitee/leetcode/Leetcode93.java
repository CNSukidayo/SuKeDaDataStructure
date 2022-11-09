package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/9 14:40
 */
public class Leetcode93 {

    private List<String> result;
    private char[] ipAddress;

    public List<String> restoreIpAddresses(String s) {
        this.result = new ArrayList<>();
        if (s.equals("00000")) {
            return result;
        }
        this.ipAddress = s.toCharArray();
        backTracking(new char[ipAddress.length + 3], 3, 0, 0);
        return result;
    }

    /**
     * @param append
     * @param count
     * @param pointIndex  加点处索引
     * @param appendIndex
     */
    private void backTracking(char[] append, int count, int pointIndex, int appendIndex) {
        // 递归出口
        if (count == 0) {
            // 判断当前的分点能否构成一个0-255区间的数字
            if (this.ipAddress.length - pointIndex > 3) {
                return;
            }
            int number = ipAddress[pointIndex] - 48;
            for (int j = pointIndex + 1; j <= this.ipAddress.length - 1; j++) {
                number *= 10;
                number += ipAddress[j] - 48;
            }
            if (ipAddress[pointIndex] - 48 == 0) {
                if (number == 0) {
                    append[appendIndex] = ipAddress[pointIndex];
                    this.result.add(new String(append));
                }
                return;
            }
            if (!(number >= 0 && number <= 255)) {
                return;
            }
            for (int i = pointIndex; i < ipAddress.length; i++) {
                append[i + (appendIndex - pointIndex)] = ipAddress[i];
            }
            this.result.add(new String(append));
        } else {
            for (int i = pointIndex; i < ipAddress.length - 1; i++) {
                // 判断当前的分点能否构成一个0-255区间的数字
                if (i - pointIndex > 2) {
                    break;
                }
                int number = ipAddress[pointIndex] - 48;
                for (int j = pointIndex + 1; j <= i; j++) {
                    number *= 10;
                    number += ipAddress[j] - 48;
                }
                if (!(number >= 0 && number <= 255)) {
                    break;
                }
                // 这里添加的逻辑可能要改
                append[appendIndex] = ipAddress[i];
                append[appendIndex + 1] = '.';
                appendIndex++;
                backTracking(append, count - 1, i + 1, appendIndex + 1);
                // 如果某次加点处为0,则该位置不能再递归
                if (ipAddress[pointIndex] == '0') {
                    break;
                }
            }
        }
    }


}
