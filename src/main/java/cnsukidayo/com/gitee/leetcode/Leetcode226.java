package cnsukidayo.com.gitee.leetcode;

import javax.swing.tree.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/10/6 21:11
 **/
public class Leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftNode = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = leftNode;
        return root;
    }

    public class TreeNode {
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
