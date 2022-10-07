package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/7 13:39
 */
public class Leetcode231 {
public boolean isPowerOfTwo(int n) {
    if (n < 1) {
        return false;
    }
    while (true) {
        if (n == 1) {
            return true;
        }
        if ((n & 1) != 0) {
            return false;
        }
        n >>= 1;
    }
}
}
