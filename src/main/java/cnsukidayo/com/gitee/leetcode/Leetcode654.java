package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/10/22 21:23
 */
public class Leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        // 找到最大的节点
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) if (nums[i] > nums[maxIndex]) maxIndex = i;

        TreeNode root = new TreeNode(nums[maxIndex]);

        // 构造左子树
        root.left = buildTree(nums, left, maxIndex - 1);
        // 构造右子树
        root.right = buildTree(nums, maxIndex + 1, right);
        return root;
    }

}
