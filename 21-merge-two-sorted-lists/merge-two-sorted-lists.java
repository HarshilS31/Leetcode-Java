class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        else if(list2==null) return list1;
        ListNode list3 = new ListNode(-1);
        ListNode i=list1;
        ListNode j=list2;
        if(i.val<j.val) {
            list3.val=i.val;
            i=i.next;
        }else {
            list3.val=j.val;
            j=j.next;
        }
        ListNode temp = list3;
        while(i!=null && j!=null) {
            if(i.val<j.val) {
                temp.next=new ListNode(i.val);
                i=i.next;
            }else {
                temp.next=new ListNode(j.val);
                j=j.next;
            }
            temp=temp.next;
        } 
        while(i!=null) {
            temp.next=new ListNode(i.val);
            i=i.next;
            temp=temp.next;
        }
        while(j!=null) {
            temp.next=new ListNode(j.val);
            j=j.next;
            temp=temp.next;
        }
        return list3;   
    }
}