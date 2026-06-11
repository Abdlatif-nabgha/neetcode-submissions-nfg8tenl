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
    public ListNode middleNode(ListNode head) {
        //brute force
        //tc: O(n+(n/2))
        //sc: O(1)
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int mid=length/2+1;
        temp=head;
        while(temp!=null){
            mid--;
            if(mid==0)  break;
            temp=temp.next;
        
        }
        return temp;
    }
}
