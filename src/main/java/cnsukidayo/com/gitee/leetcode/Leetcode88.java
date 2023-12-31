package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/6 14:09
 */
public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        while (n != 0) {
            if (m == 0) {
                nums1[index--] = nums2[n-- - 1];
                continue;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[index--] = nums1[m-- - 1];
            } else {
                nums1[index--] = nums2[n-- - 1];
            }
        }
    }
}
