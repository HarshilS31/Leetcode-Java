class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=0;i<n;i++) dp[i][0]=1;
        for(int i=n-1;i>=0;i--) {
            for(int j=1;j<=amount;j++) {
                dp[i][j]=dp[i+1][j];
                if(j>=coins[i]) dp[i][j]+=dp[i][j-coins[i]];
            }
        }
        return dp[0][amount];
 

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