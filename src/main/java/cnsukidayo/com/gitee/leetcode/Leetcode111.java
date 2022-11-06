package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/6 16:00
 */
public class Leetcode111 {

public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    if (root.left == null && root.right == null) {
        return 1;
    }

    int result = Integer.MAX_VALUE;
    if (root.left != null) {
        result = Math.min(minDepth(root.left), result);
    }
    if (root.right != null) {
        result = Math.min(minDepth(root.right), result);
    }

    return result + 1;
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
