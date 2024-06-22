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
        ListNode sen = new ListNode(0);
        
        ListNode cur = sen;
        int carry = 0;
        
        // Generate results for the addition while there are digits in a number or a carry digit to be processed.
        while (l1 != null || l2 != null || carry != 0) {
            
            // If a digit is null, substitute its value with 0.
            int d1 = (l1 == null) ? 0 : l1.val;
            int d2 = (l2 == null) ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            int res = sum % 10;
            
            // Compute the carry digit for the current addition.
            carry = sum / 10;
            
            // Generate a new node for the result of the current addition.
            ListNode resNode = new ListNode(res);
            cur.next = resNode;
            cur = cur.next;

            // Advance the given numbers.
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        
        // Return the head attached to the dummy node.
        return sen.next;
    }
}