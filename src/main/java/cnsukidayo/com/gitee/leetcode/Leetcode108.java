package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/10/8 17:43
 */
public class Leetcode108 {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return DFS(0, nums.length - 1);
    }

    private TreeNode DFS(int left, int right) {

        if (left > right) return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = DFS(left, mid - 1);
        root.right = DFS(mid + 1, right);

        return root;
    }
}
