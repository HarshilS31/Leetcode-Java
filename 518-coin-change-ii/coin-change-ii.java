class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return solve(amount,coins,0,dp);
    }
    public int solve(int amount,int[] coins,int i,int[][] dp) {
        if(amount==0) return 1;
        if(amount<0 || i==coins.length) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        dp[i][amount] = solve(amount,coins,i+1,dp);
        if(amount>=coins[i]) {
            dp[i][amount]+=solve(amount-coins[i],coins,i,dp);
        }
        return dp[i][amount];

    }
}