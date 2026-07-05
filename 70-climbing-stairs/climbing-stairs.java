class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memo(n,dp);
        
    }
    public int memo(int i,int[] dp) {
        if(i<=2) return i;
        if(dp[i]!=-1) return dp[i];
        else return dp[i]=memo(i-1,dp)+memo(i-2,dp);
    }
    

}