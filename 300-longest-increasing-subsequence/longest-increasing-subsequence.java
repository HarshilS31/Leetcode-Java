class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        if(n==1) return 1;
        return LIS(nums,0,-1,dp);
    }
    public int LIS(int[] nums,int idx, int prevIdx,int[][] dp) {
        if(idx==nums.length) return 0;
        if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx+1];
        int len = LIS(nums,idx+1,prevIdx,dp);
        if(prevIdx == -1 || nums[idx]>nums[prevIdx]) {
            len = Math.max(len,1+LIS(nums,idx+1,idx,dp));
        }
        return dp[idx][prevIdx+1]=len;

    }
}