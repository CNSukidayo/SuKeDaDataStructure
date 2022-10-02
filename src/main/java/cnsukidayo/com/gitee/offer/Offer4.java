package cnsukidayo.com.gitee.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: sukidayo
 * @date: 2022/10/2 10:09
 */
public class Offer4 {
    int[] array = new int[32];

    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            for (int j = array.length - 1; j > -1; j--) {
                if (currentNumber != 0) {
                    array[j] += 1 & currentNumber;
                    currentNumber >>= 1;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] %= 3;
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result <<= 1;
            result += array[i];
        }
        return result;
    }
}
