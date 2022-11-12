package cnsukidayo.com.gitee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/10 18:21
 */
public class Leetcode207 {
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }

        // 初始化map,并且初始化入度数组
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> value = map.get(prerequisites[i][0]);
            // 查看有无被指向节点
            if (value == null) {
                value = new ArrayList<>();
                value.add(0);
                map.put(prerequisites[i][0], value);
            }
            // 添加被指向节点的入度
            value.set(0, value.get(0) + 1);

            List<Integer> side = map.get(prerequisites[i][1]);
            if (side == null) {
                side = new ArrayList<>();
                map.put(prerequisites[i][1], side);
                side.add(0);
            }
            // 添加出边
            side.add(prerequisites[i][0]);
        }
        short flag = 0;
        Collection<List<Integer>> values = map.values();
        while (flag == 0) {
            flag = 1;
            for (List<Integer> value : values) {
                Integer number = value.get(0);
                if (number == 0) {
                    flag = 0;
                    value.set(0, -1);
                    for (int i = 1; i < value.size(); i++) {
                        List<Integer> temp = map.get(value.get(i));
                        temp.set(0, temp.get(0) - 1);
                    }
                    // 有可能不需要加break
                    break;
                } else if (number != -1) {
                    flag = -1;
                }
            }
        }
        return flag == 1 ;
    }
     */

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

}
