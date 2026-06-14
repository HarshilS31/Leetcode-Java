class Solution {
    public int pairSum(ListNode head) {
        int size=0;
        ListNode temp=head;
        while(temp!=null) {
            temp=temp.next;
            size++;
        }
        temp=head;
        if(size==2) return temp.val+temp.next.val;
        int[] twinSums=new int[size/2];
        int i=0;
        while(temp!=null) {
            if(i<size/2) {
                twinSums[i]+=temp.val;
            }
            else if(i>=size/2) {
                int j=size-i-1;
                twinSums[j]+=temp.val;
            }
            i++;
            temp=temp.next;
        }
        int maxSum=0;
        for(int sum:twinSums) maxSum=sum > maxSum ? sum:maxSum;
        return maxSum;    
    }
}