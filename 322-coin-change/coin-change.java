class Solution {
    int minCoins=0;
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int minCoins = numCoins(coins,amount,0,dp);
        return minCoins ==1_000_000_000 ? -1 : minCoins;
    }
    int numCoins(int[] coins,int amount,int i,int[][] dp) {
        if(amount==0) return 0;
        if(amount<0 || i==coins.length) return 1_000_000_000;
        if(dp[amount][i]!=-1) return dp[amount][i];
        int pick=1+numCoins(coins,amount-coins[i],i,dp);
        int skip=numCoins(coins,amount,i+1,dp);
        return dp[amount][i]=Math.min(pick,skip);
    
    }
}