package cnsukidayo.com.gitee.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: sukidayo
 * @date: 2022/10/29 11:16
 */
public class Leetcode973 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] distance = new int[points.length][3];
        int[][] result = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            distance[i][0] = points[i][0];
            distance[i][1] = points[i][1];
            distance[i][2] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }

        Queue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> o2[2] - o1[2]);
        for (int i = 0; i < points.length; i++) {
            queue.offer(distance[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int index = 0;
        for (int[] ints : queue) {
            result[index][0] = ints[0];
            result[index][1] = ints[1];
            index++;
        }
        return result;
    }
}
