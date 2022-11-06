package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/11/3 12:58
 */
public class Leetcode1382 {

    public TreeNode balanceBST(TreeNode root) {
        return avlTree(root, root);
    }

    private TreeNode avlTree(TreeNode pre, TreeNode root) {
        if (root == null) {
            return null;
        }
        // 找到左子树
        TreeNode left = avlTree(root, root.left);
        // 找到右子树
        TreeNode right = avlTree(root, root.right);
        // 获得左子树的深度
        int leftDepth = maxDepth(left);
        // 获得右子树的深度
        int rightDepth = maxDepth(right);

        if (leftDepth - rightDepth > 1) {
            // 这两步交换顺序好像没什么问题
            TreeNode temp = root.left.right;
            root.left.right = root;
            pre.left = root.left;
            root.left = temp;
            root = pre.left;
        } else if (rightDepth - leftDepth > 1) {
            TreeNode temp = root.right.left;
            root.right.left = root;
            pre.right = root.right;
            root.right = temp;
            root = pre.right;
        }
        return root;
    }

    /**
     * 返回树的深度
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
