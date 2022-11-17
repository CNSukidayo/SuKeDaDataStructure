package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: sukidayo
 * @date: 2022/11/15 19:21
 */
public class Leetcode743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Key:节点编号 value:初始节点到各节点的距离 把map变为数组,索引为节点编号,value为初始节点到各节点的距离 还需要一个step数组用于保存哪些路径已经走过
        int[] dist = new int[n + 1];
        boolean[] compare = new boolean[n + 1];
        List<List<Point>> picture = new ArrayList<>(n + 1);
        Queue<Point> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        for (int i = 0; i < n + 1; i++) {
            picture.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            Point point = new Point(times[i][1], times[i][2]);
            picture.get(times[i][0]).add(point);
        }
        queue.add(new Point(k, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (!compare[poll.id]) {
                compare[poll.id] = true;
                dist[poll.id] = poll.weight;
                count++;
            } else {
                continue;
            }
            for (Point point : picture.get(poll.id)) {
                if (!compare[point.id]) {
                    point.weight += poll.weight;
                    queue.add(point);
                }
            }
        }
        int result = 0;
        for (int i : dist) {
            result = Math.max(result, i);
        }
        return count == n ? result : -1;
    }

    class Point {
        int id;
        int weight;

        public Point(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }


}
