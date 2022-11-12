package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: sukidayo
 * @date: 2022/11/10 16:33
 */
public class Leetcode133 {

    private final Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Node result = map.get(node.val);
        if (result == null) {
            result = new Node(node.val,new ArrayList<>(node.neighbors.size()));
            map.put(result.val, result);
        }
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node add = map.get(node.neighbors.get(i).val);
            if (add == null) {
                add = cloneGraph(node.neighbors.get(i));
            }
            result.neighbors.add(add);
        }
        return result;
    }
}
