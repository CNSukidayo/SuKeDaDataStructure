package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/8 10:09
 */
public class Leetcode326 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (true) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                break;
            }
        }
        return n == 1;
    }
}
