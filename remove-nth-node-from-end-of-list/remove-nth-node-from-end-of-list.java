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
        ListNode end = head;
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode start = s;
        
        for(int i = 0; i< n-1; i++) {
            end = end.next;
        }
       
        while(end.next!=null){
            end = end.next;
            start = start.next;
        }
        start.next = start.next.next;
        return s.next;
        
    }
}