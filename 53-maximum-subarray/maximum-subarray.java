class Solution {
    int maxVal=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        maxSum(nums,n-1,dp);
        return maxVal;

    }
    public int maxSum(int[] nums,int idx,int[] dp)  {
        if(idx==0) {
            maxVal=Math.max(maxVal,nums[0]);
            return nums[0];
        }
        if(dp[idx]!=-1) return dp[idx];
        int sum=Math.max(nums[idx],nums[idx]+maxSum(nums,idx-1,dp));
        maxVal=Math.max(maxVal,sum);
        return dp[idx]=sum;
    }
}