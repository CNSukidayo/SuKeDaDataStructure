package cnsukidayo.com.gitee.leetcode;

import javax.swing.tree.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/10/6 15:01
 */
public class Leetcode100 {
boolean result = true;

public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
        return true;
    } else if (p == null || q == null) {
        return false;
    }
    if (p.val != q.val) {
        result = false;
    }
    if (p.left != null && q.left != null) {
        isSameTree(p.left, q.left);
    } else if (p.left != null || q.left != null) {
        result = false;
    }
    if (p.right != null && q.right != null) {
        isSameTree(p.right, q.right);
    } else if (p.right != null || q.right != null) {
        result = false;
    }
    return result;
}
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
