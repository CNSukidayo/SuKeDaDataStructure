package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/11/16 14:47
 */
public class Leetcode684 {


    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {

        parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int[] result = union(edges[i][0], edges[i][1]);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    /**
     * @param A 待合并的节点A
     * @param B 待合并的节点B,把B添加到A中
     * @return 返回是否可以合并, 如果不可以合并代表当前图中存在回路
     */
    private int[] union(int A, int B) {
        int aGather = findParent(A);
        int bGather = findParent(B);
        if (aGather != bGather) {
            parent[bGather] = aGather;
            return null;
        } else {
            return new int[]{A, B};
        }

    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return findParent(parent[node]);
    }

}
