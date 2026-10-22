class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int num:nums) sum+=num;
        Boolean[][] dp = new Boolean[n][(sum/2)+1];
        if(sum%2==1) return false;
        return targetSum(nums,0,sum/2,dp);
    }
    public boolean targetSum(int[] nums,int i,int target,Boolean[][] dp) {
        if(target<0 || i==nums.length) return false;
        if(target==0) return true;
        if(dp[i][target]!=null) return dp[i][target];
        return dp[i][target]=targetSum(nums,i+1,target,dp) || targetSum(nums,i+1,target-nums[i],dp);
    }
}