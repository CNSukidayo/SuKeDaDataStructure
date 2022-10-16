package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.ListNode;

/**
 * @author: sukidayo
 * @date: 2022/10/15 21:41
 */
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        return head == null || head.next == null ? head : sort(head, this.right);
    }

    private ListNode right = null;
    private boolean isFirst = true;

    // 找到中间的节点
    private ListNode middleNode(ListNode listNode, ListNode right) {
        // 慢指针
        ListNode slow = listNode;
        // 快指针
        ListNode fast = listNode.next;
        // 临时指针
        ListNode pre = fast;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            pre = fast.next;
            fast = fast.next.next;
        }
        if (isFirst) {
            this.right = pre;
            if (this.right != null && this.right.next != null) {
                this.right = this.right.next;
            }
        }
        return slow;
    }

    private ListNode sort(ListNode left, ListNode right) {
        if (left == right) {
            return left;
        }
        // 找到中间节点
        ListNode middle = middleNode(left, right);
        if (isFirst) {
            isFirst = false;
            right = this.right;
        }
        // 找到左侧的头结点
        ListNode leftNode = sort(left, middle);
        // 找到右侧的头结点
        ListNode rightNode = sort(middle.next, right);
        // 如果左边的值大于右边,则让右边的下一个设为左边,这里有一个复杂的循环判断
        mergeList(left, middle.next, right);
        return left;
    }

    private void mergeList(ListNode left, ListNode middle, ListNode right) {
        ListNode leftHead = left;
        ListNode leftDead = middle;
        ListNode rightDead = right.next;
        ListNode head = null;
        ListNode end = null;
        ListNode endPre = null;
        while (true) {
            int min;
            if (left.val > middle.val) {
                min = middle.val;
                middle = middle.next;
            } else {
                min = left.val;
                left = left.next;
            }
            if (head == null) {
                head = new ListNode(min);
                end = head;
            } else {
                end.next = new ListNode(min);
                end = end.next;
            }
            if (left == leftDead) {
                while (middle != rightDead) {
                    endPre = end;
                    end.next = new ListNode(middle.val);
                    end = end.next;
                    middle = middle.next;
                }
                break;
            }
            if (middle == rightDead) {
                while (left != leftDead) {
                    endPre = end;
                    end.next = new ListNode(left.val);
                    end = end.next;
                    left = left.next;
                }
                break;
            }
        }
        leftHead.val = head.val;
        leftHead.next = head.next;
        right.val = end.val;
        if (endPre == head) {
            leftHead.next = right;
        } else {
            endPre.next = right;
        }
    }

}
