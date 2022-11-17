package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/11/16 19:54
 */
public class Leetcode785 {
    private int[] parent;

    public boolean isBipartite(int[][] graph) {
        this.parent = new int[graph.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (isConnect(i, graph[i][j])) {
                    return false;
                }
                union(graph[i][0],graph[i][j]);
            }
        }
        return true;
    }

    private void union(int A, int B) {
        int aGather = findParent(A);
        int bGather = findParent(B);
        if (aGather != bGather) {
            parent[bGather] = aGather;
        }
    }

    private boolean isConnect(int A, int B) {
        return findParent(A) == findParent(B);
    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return findParent(parent[node]);
    }

}
