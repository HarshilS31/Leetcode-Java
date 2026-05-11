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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=slow;
        ListNode prev=null;
        while(curr!=null) {
            ListNode Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        ListNode left=head;
        ListNode right=prev;
        while(right!=null) {
            if(right.val!=left.val) return false;
            left=left.next;
            right=right.next;
        }
        return true;
 
    }
}