package cnsukidayo.com.gitee.leetcode;

import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/16 22:29
 */
public class Leetcode841 {

    private boolean[] step;
    private List<List<Integer>> rooms;
    private int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        this.step = new boolean[rooms.size()];
        dfs(0);
        return count == rooms.size();
    }

    private void dfs(int i) {
        if (!step[i]) {
            count++;
            step[i] = true;
        }
        for (int j = 0; j < rooms.get(i).size(); j++) {
            if (!step[rooms.get(i).get(j)]) {
                dfs(rooms.get(i).get(j));
            }
        }
    }

}
