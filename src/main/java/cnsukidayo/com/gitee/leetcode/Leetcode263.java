package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/7 21:53
 */
public class Leetcode263 {
public boolean isUgly(int n) {
    if (n < 1) {
        return false;
    }
    while (true) {
        if (n % 5 == 0) {
            n /= 5;
        } else if (n % 3 == 0) {
            n /= 3;
        } else if (n % 2 == 0) {
            n /= 2;
        } else {
            break;
        }
    }
    return n == 1;
}
}
