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
    
    public int getListLength(ListNode head) {
        int listLength = 0;
        while (head != null) {
            listLength++;
            head = head.next;
        }
        return listLength;
    }
    
    public void reorderList(ListNode head) {
        int listLength = getListLength(head);
        
        if (listLength < 3) {
            return;
        }
        
        ListNode[] nodes = new ListNode[listLength];
        int nodeIdx = 0;
        
        ListNode ptr = head;
        while (ptr != null) {
            nodes[nodeIdx++] = ptr;
            ptr = ptr.next;
        }
    
        int start = 0;
        int end = listLength - 1;
        
        while (start < end) {
            ListNode temp1 = nodes[start].next;
            ListNode temp2 = nodes[end].next;
            
            nodes[start].next = nodes[end];
            nodes[end].next = temp1;
            start++;
            end--;
        }
        
        nodes[(listLength / 2)].next = null;
    }
}