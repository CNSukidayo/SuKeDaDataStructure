package cnsukidayo.com.gitee.leetcode;

import java.util.*;

/**
 * @author: sukidayo
 * @date: 2022/11/14 19:03
 */
public class Leetcode399 {

    private Set<String> status;
    private Map<String, Map<String, Double>> picture;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 保存当前哪些点是正在被搜索的
        this.status = new HashSet<>();
        // Key为图中的节点 value的Key为当前节点的相邻节点,value的value为当前节点与该相邻节点之间的权值.
        // 本题有优化的空间,但是我不想想了...
        this.picture = new HashMap<>();
        // 结果集
        double[] result = new double[queries.size()];
        // 初始化图
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            Map<String, Double> point = picture.get(equation.get(0));
            if (point == null) {
                point = new HashMap<>();
            }
            point.put(equation.get(1), values[i]);
            picture.put(equation.get(0), point);
            point = picture.get(equation.get(1));
            if (point == null) {
                point = new HashMap<>();
            }
            point.put(equation.get(0), 1 / values[i]);
            picture.put(equation.get(1), point);

        }
        // 开始解答,深度优先遍历
        for (int i = 0; i < queries.size(); i++) {
            List<String> question = queries.get(i);
            String start = question.get(0);
            String end = question.get(1);
            double ans = -1;
            if (picture.get(start) != null && picture.get(end) != null) {
                if (start.equals(end)) {
                    ans = 1;
                    result[i] = ans;
                    continue;
                }
                this.flag = false;
                status.add(start);
                ans = dfs(end, picture.get(start), 1);
                status.clear();
            }
            result[i] = ans;
        }
        return result;
    }

    private boolean flag;

    private double dfs(String end, Map<String, Double> nowPoint, double pre) {
        for (Map.Entry<String, Double> entry : nowPoint.entrySet()) {
            if (!status.contains(entry.getKey())) {
                if (entry.getKey().equals(end)) {
                    flag = true;
                    return entry.getValue() * pre;
                }
                status.add(entry.getKey());
                double dfs = dfs(end, this.picture.get(entry.getKey()), pre * entry.getValue());
                status.remove(entry.getKey());
                if (flag) {
                    return dfs;
                }
            }
        }
        return -1;
    }

}
