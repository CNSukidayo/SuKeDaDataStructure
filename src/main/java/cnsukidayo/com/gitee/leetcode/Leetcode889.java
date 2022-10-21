package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/10/21 13:09
 */
public class Leetcode889 {

    private int[] preorder;
    private int[] postorder;


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;

        return buildTree(0, preorder.length - 1, 0);
    }

    private TreeNode buildTree(int left, int right, int rootIndex) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(postorder[left]);
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        // 找到左子树的根节点
        int index = left;
        // rootIndex + 1 代表左子树的根节点
        for (; preorder[rootIndex + 1] != postorder[index]; index++) ;

        // 构建左子树
        root.left = buildTree(left, index, rootIndex + 1);
        // 构建右子树
        root.right = buildTree(index + 1, right - 1, rootIndex + index - left + 2);
        return root;
    }

}
