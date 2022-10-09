//package cnsukidayo.com.gitee.leetcode;
//
//import cnsukidayo.com.gitee.script.ListNode;
//import cnsukidayo.com.gitee.script.TreeNode;
//
///**
// * @author: sukidayo
// * @date: 2022/10/9 10:32
// */
//public class Leetcode109 {
//
//    public TreeNode sortedListToBST(ListNode head) {
//        return sortedListToBST(head, head);
//    }
//
//    public TreeNode sortedListToBST(ListNode leftNode, ListNode rootNode, ListNode rightNode) {
//
//
//        // 获取右节点
//        TreeNode right = sortedListToBST(leftNode.next, rootNode.next, rightNode.next);
//        // 获取父节点
//        TreeNode parent = new TreeNode(rootNode.val);
//        // 获取左节点
//        TreeNode left = new TreeNode(leftNode.val);
//        parent.right = right;
//        parent.left = left;
//        return parent;
//    }
//
//}
