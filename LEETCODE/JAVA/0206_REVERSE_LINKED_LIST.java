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
    public ListNode reverseList(ListNode head) {

        // Base cases: The list is empty or contains only one node.
        if (head == null || head.next == null) {
            return head;
        }
        
        // When the function call reaches the tail of the list, it will be passed back as the head to all earlier recursive calls.
        ListNode newHead = reverseList(head.next);
        
        // Reverse the direction of the link between the current node and the next node.
        ListNode nextNode = head.next;
        nextNode.next = head;
        
        // Make the current node point to null.
        head.next = null;
        
        // Return the new head of the linked list on each recursive call.
        return newHead;
    }
}