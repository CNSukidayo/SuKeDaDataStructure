package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/15 19:00
 */
public class Leetcode797 {

    private List<List<Integer>> result;
    private int n;
    private int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.result = new ArrayList<>();
        this.n = graph.length - 1;
        this.graph = graph;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(list, 0);
        return result;
    }

    private void dfs(List<Integer> append, int index) {
        if (index == this.n) {
            this.result.add(new ArrayList<>(append));
        } else {
            for (int i = 0; i < this.graph[index].length; i++) {
                append.add(graph[index][i]);
                dfs(append, graph[index][i]);
                append.remove(append.size() - 1);
            }
        }
    }

}
