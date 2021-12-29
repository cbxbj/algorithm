package org.example.double_pointer;

import org.example.util.ListNode;

/**
 * 剑指 Offer(第2版) 22.链表中倒数第k个节点
 * 快慢指针
 * 简单
 * 总结:利用快慢指针
 */
public class GetKthFromEnd_22J {

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        System.out.println(getKthFromEnd(head, 2));
    }

    /**
     * 快指针先走K步,快慢指针再以相同速率走
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
