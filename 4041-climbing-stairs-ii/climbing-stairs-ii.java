class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        return solve(costs,n,dp);
    }
    public int solve(int[] costs,int i,int[] dp) {
        if(i<0) return 0; 
        if(dp[i]!=-1)  return dp[i];
        int jump1=1+solve(costs,i-1,dp);
        int jump2=4+solve(costs,i-2,dp);
        int jump3=9+solve(costs,i-3,dp);
        return dp[i]=costs[i-1]+Math.min(jump1,Math.min(jump2,jump3));

    }
}