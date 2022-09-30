package cnsukidayo.com.gitee.offer;

import java.util.HashSet;

public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        boolean[] temp = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i]]) {
                return nums[i];
            }
            temp[nums[i]] = true;
        }
        return 0;
    }
}
