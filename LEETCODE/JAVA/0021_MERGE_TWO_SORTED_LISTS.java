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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // If one list is null, return the other.
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            // If the value of list1 head > value of list2 head, recursively merge the remainder of list1 with list2.
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            // If the value of list1 head <= value of list2 head, recursively merge the remainder of list2 with list1.
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}