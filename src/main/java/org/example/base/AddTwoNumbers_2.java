package org.example.base;

import org.example.util.ListNode;

/**
 * 2.两数相加
 * 中等
 * 总结:比较简单分析出和与余就可
 */
public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(new ListNode(), new ListNode()));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int sum;
        int carry = 0;
        boolean l1IsNull;
        boolean l2IsNull;
        while (l1 != null || l2 != null) {
            l1IsNull = l1 == null;
            l2IsNull = l2 == null;
            sum = (l1IsNull ? 0 : l1.val) + (l2IsNull ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum %= 10;
            current.next = new ListNode(sum);
            current = current.next;
            l1 = (l1IsNull ? null : l1.next);
            l2 = (l2IsNull ? null : l2.next);
        }
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        return result.next;
    }
}
