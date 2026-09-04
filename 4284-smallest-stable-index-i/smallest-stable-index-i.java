class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int minIdx=n+1;
        for(int i=0;i<n;i++) {
            int currMin=Integer.MAX_VALUE;
            int currMax=Integer.MIN_VALUE;
            for(int j=0;j<=i;j++) {
                currMax = Math.max(currMax,nums[j]);
            }
            for(int x=i;x<n;x++) {
                currMin = Math.min(currMin,nums[x]);
            }
            int stability = currMax-currMin;
            if(stability<=k) {
                minIdx=Math.min(minIdx,i);
            }
        } 
        return minIdx == n+1 ? -1 : minIdx;
        
    }
}