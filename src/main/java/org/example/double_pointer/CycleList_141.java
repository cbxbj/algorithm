package org.example.double_pointer;

import org.example.util.ListNode;

/**
 * 141.环形链表
 * 142.环形链表II
 * 双指针:
 * 1.快慢指针(使用该思想)
 * 2.左右指针
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * 总结:利用快慢指针
 */
public class CycleList_141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        System.out.println(hasCycle(head));
        System.out.println(detectCycle(head));
    }

    /**
     * 141.环形链表
     * 是环形链表返回true,否则返回false
     * 简单
     *
     * @param head 头节点
     * @return 是否是环形链表
     */
    public static boolean hasCycle(ListNode head) {
        //基于快慢指针思想
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 142.环形链表II
     * 是环形链表返回尾节点的next节点
     * 中等
     *
     * @param head 头节点
     * @return 是否是环形链表
     */
    public static ListNode detectCycle(ListNode head) {
        //基于快慢指针思想
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

}
