/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // 1 -> 2 -> 3 ->
        // StringBuiler number1 = 321
        // 4 -> 5 -> 6
        // StringBuiler number2 = 654

        ListNode curr1 = l1, curr2 = l2;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            if (sum < 10) {
                carry = 0;
                tail.next = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            tail = tail.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr1 != null) {
            int sum = curr1.val + carry;
            if (sum < 10) {
                carry = 0;
                tail.next = new ListNode(sum);
            } else {
                carry = sum / 10;
                tail.next = new ListNode(sum % 10);
            }
            tail = tail.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            int sum = curr2.val + carry;
            if (sum < 10) {
                carry = 0;
                tail.next = new ListNode(sum);
            } else {
                carry = sum / 10;
                tail.next = new ListNode(sum % 10);
            }
            tail = tail.next;
            curr2 = curr2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }

        
        return head.next;
    }
}
