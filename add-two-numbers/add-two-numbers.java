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
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(l1!=null || l2!=null) {
            int f1 = 0;
            int f2 = 0;
            if(l1!=null) f1 = l1.val;
            if(l2!=null) f2 = l2.val;
            int current = f1+f2+carry;
            // if(l1.next==null&&l2.next==null) {
            //     sb.append(current);
            // }
            if(current>=10){
                sb.append(current-10);
                carry=1;
            } else {
                carry=0;
                sb.append(current);
            }
            if(l1!=null)
            l1 = l1.next;
            if(l2!=null)
            l2 = l2.next;
        }
        if(carry==1){
            sb.append(1);
        }
        System.out.println(sb);
        ListNode head = new ListNode(Integer.parseInt(sb.substring(0,1)));
        ListNode temp = head;
        for(int i = 1; i< sb.length(); i++ ){
            head.next = new ListNode(Integer.parseInt(sb.substring(i,i+1)));
            head = head.next;
        }
        return temp;
    }
    
}