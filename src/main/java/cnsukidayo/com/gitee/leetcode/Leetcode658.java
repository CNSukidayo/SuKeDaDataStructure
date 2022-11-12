package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/11 16:32
 */
public class Leetcode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 首先找到左侧最接近x的索引
        int left = 0, right = arr.length - 1, middle;
        List<Integer> result = new ArrayList<>(k);
        /*
        二分查找后,保证left是指向最接近x的元素的索引,并且对于当前判断的元素如果不符合我们并不将它从待搜索区间中删除.
        因为我们很有可能找不到恰好等于x的元素,那么当前元素就有可能是最接近x的那个元素.
        */
        while (left + 1 < right) {
            middle = left + ((right - left) >> 1);
            if (arr[middle] == x) {
                left = middle;
                break;
            } else if (arr[middle] > x) {
                right = middle;
            } else {
                left = middle;
            }
        }
        right = left + 1;
        // 找到最接近x的元素索引后,往该元素的左右两边延伸判断.
        while (k > 0) {
            if (left > -1 && right < arr.length) {
                if (arr[right] - x < x - arr[left]) {
                    right++;
                } else {
                    left--;
                }
            } else if (left > -1) {
                left--;
            } else {
                right++;
            }
            k--;
        }
        // 将所有结果添加到结果集中
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}
