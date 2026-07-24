class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return LIS(0,-1,nums,dp);
    }
    public int LIS(int idx,int prevIdx,int[] nums,int[][] dp) {
        if(idx==nums.length) return 0;
        if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx+1];
        int len = LIS(idx+1,prevIdx,nums,dp);
        if(prevIdx==-1 || nums[idx]>nums[prevIdx]) {
            len=Math.max(len,1+LIS(idx+1,idx,nums,dp));
        }
        return dp[idx][prevIdx+1]=len;
    }
}