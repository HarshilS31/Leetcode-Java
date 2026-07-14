class Solution {
    public int perfectSum(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        for(int[]  arr : dp) Arrays.fill(arr,-1);
        return findSum(nums,dp,target,0);
    }

    public int findSum(int[] nums,int[][] dp,int target,int i) {
        if(target<0) return 0; 
        if(i==nums.length) return target == 0 ? 1 :0;
        if(dp[i][target]!=-1) return dp[i][target];
        int pick = findSum(nums,dp,target-nums[i],i+1);
        int skip =findSum(nums,dp,target,i+1);
        return dp[i][target]=pick+skip;
    }
}