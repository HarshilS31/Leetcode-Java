class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[1]=costs[0]+1;
        if(n==1) return dp[1];
        dp[2]=Math.min(costs[1]+4,dp[1]+costs[1]+1);
        if(n==2) return dp[2];
        dp[3]=Math.min(costs[2]+9,Math.min(dp[1]+costs[2]+4,dp[2]+costs[2]+1));
        for(int i=4;i<=n;i++) {
            dp[i]=costs[i-1]+Math.min(dp[i-1]+1,Math.min(dp[i-2]+4,dp[i-3]+9));
        }
        return dp[n];
        
    }
}