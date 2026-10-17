class Solution {
    int minCoins=0;
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int minCoins = numCoins(coins,amount,0,dp);
        return minCoins ==1_000_000_000 ? -1 : minCoins;
    }
    int numCoins(int[] coins,int amount,int i,int[][] dp) {
        if(amount==0) return 0;
        if(i==coins.length) return 1_000_000_000;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int skip=numCoins(coins,amount,i+1,dp);
        if(coins[i]>amount) return dp[i][amount]=skip;
        int pick=1+numCoins(coins,amount-coins[i],i,dp);
        return dp[i][amount]=Math.min(pick,skip);
    
    }
}