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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Attach a dummy node to the head of the linked list.
        ListNode dummy = new ListNode(0, head);

        // Maintain left and right pointers on the list.
        ListNode left = dummy;
        ListNode right = head;

        // Advance the right pointer n nodes ahead.
        // Since n <= size, we are left with size - n ( >= 0 ) number of nodes to move the right and left
        // pointers. 
        while (n > 0) {
            right = right.next;
            --n;
        }

        // Advance the left and right pointer until the right pointer becomes null.
        // The left pointer should now point to the node prior to the node to be removed.
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Delete the pointer following the left node and update the next link of the left node.
        left.next = left.next.next;

        // Return the original head of the linked list.
        return dummy.next;
    }
}
