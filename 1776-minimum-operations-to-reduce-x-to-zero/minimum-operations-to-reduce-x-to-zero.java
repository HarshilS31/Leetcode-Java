class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int left=0;
        int sum=0;
        for(int num:nums) sum+=num;
        int maxLen=Integer.MIN_VALUE;
        if(sum<x) return -1;
        int target=sum-x;
        sum=0;
        for(int right=0;right<n;right++) {
            sum+=nums[right];
            while(left < n && sum>target) {
                sum-=nums[left++];
            }
            if(sum==target) maxLen = Math.max(right-left+1,maxLen);
        } 
        if(maxLen==Integer.MIN_VALUE) return -1;
        return n-maxLen;       
    }
}