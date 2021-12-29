package org.example.double_pointer;

import org.example.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 21.合并两个有序链表
 * 23.合并K个升序链表
 * 双指针
 * 左右指针
 * 总结:利用左右指针,巧妙利用PriorityQueue优先级队列
 */
public class mergeLists_21 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        System.out.println(mergeTwoLists(head, head));
        System.out.println(mergeKLists(new ListNode[]{head, head}));
    }

    /**
     * 合并2个升序链表
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        //哨兵(哑元)节点,简化while里代码书写
        ListNode temp = new ListNode(-1);
        ListNode list3 = temp;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }
        if (list1 != null)
            list3.next = list1;
        if (list2 != null) {
            list3.next = list2;
        }
        return temp.next;
    }

    /**
     * 合并K个升序链表
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        //优先级队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        ListNode cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            tail.next = cur;
            tail = tail.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return head.next;
    }
}
