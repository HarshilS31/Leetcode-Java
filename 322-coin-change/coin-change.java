class Solution {
    int minCoins=0;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int MAX = 1_000_000_000;
        int[][] dp = new int[n+1][amount+1];
        for(int i=1;i<=amount;i++) {
            dp[n][i]=MAX;
        }
        for (int i = 0; i <= n; i++) dp[i][0] = 0; 
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=amount;j++) {
                int skip = dp[i+1][j];
                if(coins[i]>j) dp[i][j]=skip;
                else {
                    int pick=1+dp[i][j-coins[i]];
                    dp[i][j]=Math.min(pick,skip);
                }
            }
        }
        return dp[0][amount]>=MAX ? -1 : dp[0][amount];
    }

}