public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) {
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle) return null;
        ListNode temp = head;
        while(slow!=temp) {
            slow=slow.next;
            temp=temp.next;
        }
        return temp;
        
    }
}