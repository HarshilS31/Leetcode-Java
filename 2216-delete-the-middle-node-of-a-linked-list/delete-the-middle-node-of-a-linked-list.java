
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int size=0;
        while(temp!=null) {
            temp=temp.next;
            size++;
        }
        if(size==1) return null;
        temp=head;
        if(size==2) {
            temp.next=null;
            return temp;
        }
        for(int i=1;i<size/2;i++) temp=temp.next;
        temp.next=temp.next.next;
        return head;

    }
}