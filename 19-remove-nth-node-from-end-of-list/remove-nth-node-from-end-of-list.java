class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1) return null;
        //Brute force
        int size=0;
        ListNode temp = head;
        while(temp!=null) {
            temp=temp.next;
            size++;
        }
        temp=head;
        if(n==size) return head.next;
        int pos = size-n-1;
        while(temp!=null && pos>0) {
            temp=temp.next;
            pos--;
        }
        temp.next=temp.next.next;
        return head;
        
    
        
    }
}