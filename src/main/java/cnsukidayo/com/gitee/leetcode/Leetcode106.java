package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/10/20 18:20
 */
public class Leetcode106 {

    private int[] postorder;
    private int[] inorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        return buildTree(0, this.postorder.length - 1, this.postorder.length - 1);
    }

    private TreeNode buildTree(int left, int right, int rootIndex) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(inorder[left]);
        }
        TreeNode root = new TreeNode(postorder[rootIndex]);
        int index = left;
        for (; postorder[rootIndex] != inorder[index]; index++) ;
        root.right = buildTree(index + 1, right, rootIndex - 1);
        root.left = buildTree(left, index - 1, rootIndex + index - right - 1);
        return root;
    }

}
