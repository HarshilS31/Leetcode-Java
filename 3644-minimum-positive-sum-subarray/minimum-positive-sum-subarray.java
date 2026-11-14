class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        for(int size=l;size<=r;size++) {
            int currSum=0;
            for(int i=0;i<size;i++) currSum+=nums.get(i);
            if(currSum>0 && currSum<min) min=currSum;
            for(int i=size;i<n;i++) {
                currSum-=nums.get(i-size);
                currSum+=nums.get(i); 
               if(currSum>0 && currSum<min) min=currSum;
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
        
    }
}