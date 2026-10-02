class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(t1!=null || t2!=null) {
            int sum = carry;
            if(t1!=null) {
                sum+=t1.val;
                t1=t1.next;
            }
            if(t2!=null) {
                sum+=t2.val;
                t2=t2.next;
            }
            carry=sum/10;
            curr.next = new ListNode(sum%10);
            curr=curr.next;
        }
        if(carry>0) {
            curr.next= new ListNode(carry);

        }
        return dummy.next;
        
        
    }
}