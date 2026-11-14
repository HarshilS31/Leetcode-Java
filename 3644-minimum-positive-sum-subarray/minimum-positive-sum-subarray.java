class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int currSum=0;
            for(int j=i;j<n;j++) {
                if(j-i+1>r) break;
                currSum+=nums.get(j);
                if(j-i+1>=l && currSum>0) minSum=Math.min(currSum,minSum);
            }
        }
        if(minSum==0 || minSum==Integer.MAX_VALUE) return -1;
        return minSum;
       
    
        
    }
}