
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next==null) return new int[]{-1,-1};
        ListNode temp = head.next;
        List<Integer>  criticalPoints = new ArrayList<>();
        int prevVal = head.val;
        int idx=1;
        while(temp.next!=null) {
            if(temp.val > prevVal && temp.val > temp.next.val) criticalPoints.add(idx);
            else if(temp.val < prevVal && temp.val < temp.next.val) criticalPoints.add(idx);
            idx++;
            prevVal=temp.val;
            temp=temp.next;
        }
        int n = criticalPoints.size();
        if(n<=1) return new int[]{-1,-1};
        Collections.sort(criticalPoints);
        if(n==2) {
            int dist = criticalPoints.get(1)-criticalPoints.get(0);
            return new int[]{dist,dist};
        }
        int maxDist = criticalPoints.get(n-1)-criticalPoints.get(0);
        int minDist = n+1;
        for(int i=0;i<n-1;i++) {
            int currDist=criticalPoints.get(i+1)-criticalPoints.get(i);
            minDist = Math.min(currDist,minDist);
        }
        return new int[]{minDist,maxDist};
 
    }
}