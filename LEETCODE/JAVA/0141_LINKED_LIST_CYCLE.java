/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // If there is an overlap between the fast and slow pointer, a cycle has been detected.
            // This is akin to having a slower and faster runner on a circular track. The faster runner will lap the slower runner eventually.
            if (slow == fast) {
                return true;
            }
        }

        // If there is no cycle, the fast pointer should reach the end of the list (be it the tail or the null point) before the slow pointer.
        return false;
    }
}