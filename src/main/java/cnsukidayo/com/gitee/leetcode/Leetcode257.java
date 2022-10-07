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
        StringBuilder value = new StringBuilder();
        getString(root, value.append(root.val));
        return result;
    }

    private void getString(TreeNode root, StringBuilder value) {
        if (root.left == null && root.right == null) {
            result.add(value.toString());
        }
        if (root.left != null) {
            getString(root.left, value.append("->").append(root.left.val));
        }
        if (root.right != null) {
            getString(root.right, value.append("->").append(root.right.val));
        }
    }

}
