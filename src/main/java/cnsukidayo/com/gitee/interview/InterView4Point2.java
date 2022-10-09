package cnsukidayo.com.gitee.interview;

import cnsukidayo.com.gitee.script.TreeNode;

/**
 * @author: sukidayo
 * @date: 2022/10/9 9:39
 */
public class InterView4Point2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }

    private TreeNode create(int[] nums, int left, int right) {

        if (left > right) return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = create(nums, left, mid - 1);
        root.right = create(nums, mid + 1, right);

        return root;
    }

}
