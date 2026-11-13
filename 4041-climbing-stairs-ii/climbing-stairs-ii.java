class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=costs[0]+1;
        if(n==1) return dp[1];
        dp[2]=costs[1]+Math.min(4,dp[1]+1);
        if(n==2) return dp[2];
        dp[3]=costs[2]+Math.min(9,Math.min(dp[2]+1,dp[1]+4));
        if(n==3)  return dp[3];
        for(int i=4;i<=n;i++) {
            dp[i]=costs[i-1]+Math.min(dp[i-3]+9,Math.min(dp[i-2]+4,dp[i-1]+1));
        }
        return dp[n];
    }
}
