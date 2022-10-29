package cnsukidayo.com.gitee.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: sukidayo
 * @date: 2022/10/29 13:02
 */
public class Leetcode1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        int[][] result = new int[matrix.length][matrix[0].length];
        Queue<Integer> queue = new PriorityQueue<>(k);
        // 初始化列
        for (int i = 0; i < matrix.length; i++) {
            cache[i][0] = matrix[i][0];
        }
        // 初始化
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                cache[i][j] = matrix[i][j] ^ cache[i][j - 1];
            }
        }
        // 拷贝行
        for (int i = 0; i < matrix[0].length; i++) {
            result[0][i] = cache[0][i];
            queue.add(result[0][i]);
            if (queue.size() > k) queue.poll();
        }
        // 求列
        for (int i = 1; i < matrix.length; i++) {
            result[i][0] = matrix[i][0] ^ result[i - 1][0];
            queue.add(result[i][0]);
            if (queue.size() > k) queue.poll();
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                result[i][j] = result[i - 1][j] ^ cache[i][j - 1] ^ matrix[i][j];
                queue.add(result[i][j]);
                if (queue.size() > k) queue.poll();
            }
        }
        return queue.poll();
    }


}
