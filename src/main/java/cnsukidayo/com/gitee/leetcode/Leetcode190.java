package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/8 17:57
 */
public class Leetcode190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += ((n >> i) & 1);
            if (i != 31) {
                result <<= 1;
            }
        }
        return result;
    }
}
