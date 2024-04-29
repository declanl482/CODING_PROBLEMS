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
        
        while (l1 != null || l2 != null || carry != 0) {
            
            int d1 = (l1 == null) ? 0 : l1.val;
            int d2 = (l2 == null) ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            int res = sum % 10;
            
            carry = sum / 10;
            
            ListNode resNode = new ListNode(res);
            cur.next = resNode;
            cur = cur.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        
        return sen.next;
    }
}