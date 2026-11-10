class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n,costs,n-1,dp);
    }
    public int solve(int n,int[] costs,int i,int[] dp) {
        if(i<0) {
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int jump1=1+solve(n,costs,i-1,dp);
        int jump2=4+solve(n,costs,i-2,dp);
        int jump3=9+solve(n,costs,i-3,dp);
        return dp[i]=costs[i]+Math.min(jump1,Math.min(jump2,jump3));

       
        

    }
}