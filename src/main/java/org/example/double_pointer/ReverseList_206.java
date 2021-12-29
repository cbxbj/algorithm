package org.example.double_pointer;

import org.example.util.ListNode;

/**
 * 206.反转链表
 * 迭代或递归方式
 * 左右指针
 * 总结:利用左右指针
 */
public class ReverseList_206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        System.out.println(reverseList(head));
    }

    /**
     * 迭代方式
     * 循环内,
     * next节点指向curr节点的下一个节点
     * 把curr节点的next节点指向pre节点
     * pre节点指向curr节点
     * curr节点指向next节点
     *
     * @param head 头节点
     * @return 反转后的头节点
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
