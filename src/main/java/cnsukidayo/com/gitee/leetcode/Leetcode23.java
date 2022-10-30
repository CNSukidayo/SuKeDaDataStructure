package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: sukidayo
 * @date: 2022/10/30 9:45
 */
public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            if (current.next.next != null) {
                queue.add(current.next.next);
            }
            current = current.next;
        }
        return dummy.next;
    }

}
