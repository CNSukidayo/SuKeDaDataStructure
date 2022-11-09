package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sukidayo
 * @date: 2022/11/9 18:26
 */
public class Leetcode95 {

    private List<TreeNode> result;
    private int n;

    public List<TreeNode> generateTrees(int n) {
        this.result = new ArrayList<>();
        this.n = n;
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            backTracking(i, 1, n, root, root, 1);
        }
        return result;
    }

    private void backTracking(int root, int left, int right, TreeNode pre, TreeNode head, int count) {
        // 递归出口
        if (count == this.n) {
            // 拷贝树
            TreeNode append = new TreeNode(head.val);
            copyTree(head, append);
            this.result.add(append);
        } else {
            // 循环构建左子树
            while (count < this.n) {
                int tempLeft = left;
                if (tempLeft < root && tempLeft > 0) {
                    pre.left = new TreeNode(tempLeft);
                    backTracking(tempLeft, left, root - 1, pre.left, head, ++count);
                    tempLeft++;
                }
                // 循环构建右子树
                int tempRight = right;
                if (tempRight > root) {
                    pre.right = new TreeNode(tempRight);
                    backTracking(tempRight, root + 1, right, pre.right, head, ++count);
                    tempRight--;
                }
            }
        }
    }


    public void copyTree(TreeNode sources, TreeNode dest) {
        if (sources.left != null) {
            dest.left = new TreeNode(sources.left.val);
            copyTree(sources.left, dest.left);
        }
        if (sources.right != null) {
            dest.right = new TreeNode(sources.right.val);
            copyTree(sources.right, dest.right);
        }
    }

}
