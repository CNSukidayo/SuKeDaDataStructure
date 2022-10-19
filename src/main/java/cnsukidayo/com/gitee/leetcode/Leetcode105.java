package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/10/19 16:31
 */
public class Leetcode105 {

    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        return buildTree(0, preorder.length - 1, 0);
    }

    /**
     * @param left      inorder数组的左边界
     * @param right     inorder数组的右边界
     * @param rootIndex preorder指向的根节点
     * @return
     */
    private TreeNode buildTree(int left, int right, int rootIndex) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(inorder[left]);
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        // 找到根节点在inorder数组中的位置,从left开始找一直到right结束
        int index = left;
        for (; preorder[rootIndex] != inorder[index]; index++) ;

        // 构建左子树
        root.left = buildTree(left, index - 1, rootIndex + 1);
        // 构建右子树
        root.right = buildTree(index + 1, right, rootIndex + index - left + 1);
        return root;
    }
}
