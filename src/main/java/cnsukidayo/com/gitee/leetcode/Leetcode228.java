package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/10/7 12:37
 */
public class Leetcode228 {
public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    int left = 0;
    int right = 0;
    if (nums.length == 0) {
        return result;
    }
    while (right < nums.length - 1) {
        if (nums[right] + 1 == nums[right + 1]) {
            right++;
        } else {
            StringBuilder add = new StringBuilder();
            add.append(nums[left]);
            if (left != right) {
                add.append("->").append(nums[right]);
            }
            result.add(add.toString());
            right++;
            left = right;
        }
    }
    StringBuilder add = new StringBuilder();
    add.append(nums[left]);
    if (left != right) {
        add.append("->").append(nums[right]);
    }
    result.add(add.toString());
    return result;
}
}
