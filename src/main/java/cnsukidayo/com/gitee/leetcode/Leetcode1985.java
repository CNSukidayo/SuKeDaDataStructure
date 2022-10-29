package cnsukidayo.com.gitee.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: sukidayo
 * @date: 2022/10/29 18:56
 */
public class Leetcode1985 {

    public String kthLargestNumber(String[] nums, int k) {
        Queue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                }
                return 0;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

}
