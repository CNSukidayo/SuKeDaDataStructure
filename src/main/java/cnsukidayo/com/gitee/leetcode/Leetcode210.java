package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/12 14:24
 */
public class Leetcode210 {


    private List<List<Integer>> lists;
    private int[] status;
    private boolean flag = true;
    private int[] stack;
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.status = new int[numCourses];
        this.lists = new ArrayList<>(numCourses);
        this.stack = new int[numCourses];
        this.index = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            this.lists.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            this.lists.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < this.lists.size(); i++) {
            if (status[i] == 0) {
                forEach(i);
            }
            if (!this.flag) {
                return new int[]{};
            }
        }

        return this.stack;

    }

    private void forEach(int index) {
        this.status[index] = 1;
        for (Integer next : lists.get(index)) {
            if (status[next] == 1) {
                flag = false;
                return;
            }
            if (status[next] == 2) {
                continue;
            }
            forEach(next);
        }
        this.status[index] = 2;
        this.stack[this.index--] = index;
    }

}
