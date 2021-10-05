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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = null;
        ListNode ss = null;
        int count = 0;
        
      
        while(start!= null) {
            if(count!=k){
                start = start.next;
                count++;
            } if(count==k) {
                count=0;
                ListNode hey = reverseList(head, k);
                if(ss==null){
                    ss = hey;
                } 
                if(end!=null){
                    end.next = hey;
                }
                
                end = head;
                head = start;
            }
            
        }
        if (end != null)
            end.next = head;
        
         return ss == null ? head : ss;
        
        
        
    }
    
    public ListNode reverseList(ListNode head, int k){
        
        ListNode ans = null;
        
        ListNode current = head;
        while(k>0){
            ListNode temp = ans;
            ListNode nex = current.next;
            //if(nex==null) return null;
            ans = current;
            ans.next = temp;
            current = nex;
            k--;
        }
        return ans;
        
    }
    
}