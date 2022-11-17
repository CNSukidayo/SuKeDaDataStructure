package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/16 21:55
 */
public class Leetcode802 {
    // 一共有四种状态:-1代表当前节点不是安全点 0代表未搜索 1代表正在搜索 2代表当前节点是安全点
    private int[] status;
    private int[][] graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.status = new int[graph.length];
        this.graph = graph;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (status[i] == 0) {
                dfs(i);
            }
            if (status[i] == 2) {
                result.add(i);
            }
        }
        return result;
    }

    private int dfs(int id) {
        if (status[id] != 0) {
            return status[id];
        }
        // 当前节点正在搜索
        status[id] = 1;
        boolean flag = true;
        for (int i = 0; i < graph[id].length; i++) {
            int result = dfs(graph[id][i]);
            if (result != 2) {
                flag = false;
                status[id] = -1;
            }
        }
        if (flag) {
            status[id] = 2;
        }
        return status[id];
    }

}
