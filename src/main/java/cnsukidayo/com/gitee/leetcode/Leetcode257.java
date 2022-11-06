package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/10/7 19:52
 */
public class Leetcode257 {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backTracking(root, "");
        return result;
    }

    private void backTracking(TreeNode root, String road) {

        if (root.left == null && root.right == null) {
            result.add(road + root.val);
        }
        // 构造左子树
        if (root.left != null) {
            backTracking(root.left, road + root.val + "->");
        }
        // 构造右子树
        if (root.right != null) {
            backTracking(root.right, road + root.val + "->");
        }
    }


}
