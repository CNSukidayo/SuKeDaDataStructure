package cnsukidayo.com.gitee.leetcode;

import java.util.PriorityQueue;

/**
 * @author: sukidayo
 * @date: 2022/10/20 19:47
 */
public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.poll();
        }
        return queue.peek();
    }

}
