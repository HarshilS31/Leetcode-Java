class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n =  lists.length;
        if(n==0) return null;
        if(n==1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list:lists) {
            if(list!=null) pq.add(list);
        }
        ListNode dummy= new ListNode(-1);
        ListNode tail=dummy;    
        while(!pq.isEmpty()) {
            tail.next = pq.poll();
            ListNode curr = tail.next;
            tail=tail.next;
            if(curr.next!=null) pq.add(curr.next);
        }
        return dummy.next;

     
        
    }
}