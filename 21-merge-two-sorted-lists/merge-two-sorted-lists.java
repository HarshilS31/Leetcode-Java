class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode temp1=list1;
        ListNode temp2=list2;
        ListNode head = new ListNode();
        ListNode temp=head;
        if(temp1.val<temp2.val) {
            head.val=temp1.val;
            temp1=temp1.next;
        } else {
            head.val=temp2.val;
            temp2=temp2.next;   
        }
        while(temp1!=null && temp2!=null) {
            if(temp1.val<temp2.val) {
                head.next=new ListNode(temp1.val);
                head=head.next;
                temp1=temp1.next;
            }else {
                head.next=new ListNode(temp2.val);
                head=head.next;
                temp2=temp2.next;
            }
        }
        while(temp1!=null) {
            head.next=new ListNode(temp1.val);
            head=head.next;
            temp1=temp1.next;
        }
        while(temp2!=null) {
            head.next=new ListNode(temp2.val);
            head=head.next;
            temp2=temp2.next;
        }
        return temp;

        
    }
}