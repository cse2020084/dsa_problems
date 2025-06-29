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

 /**
 *ms(a,low,high)
    if(low==high) return;
    mid=(l+h)/2;
    ms(a,low,mid);
    ms(a,mid+1,high);
    merge(a,l, m,h);
  */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode mid=middle(head);
        ListNode rightNode=null;
        if(mid!=null){
            rightNode=mid.next;
            mid.next=null;
        }
        
        ListNode left=sortList(head);
        ListNode right=sortList(rightNode);
        // mid.next=null;

        return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(0);
        ListNode prev=temp;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
            

        }

        if(l1==null) temp.next=l2;
        else temp.next=l1;

      
        return prev.next;
    } 


    ListNode middle(ListNode head){
        if(head==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        // ListNode mid= slow;
        return prev; 
    }
}