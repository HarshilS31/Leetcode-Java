class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return findWays(coins,dp,amount,0);
    }
    public int findWays(int[] coins,int[][] dp,int amount,int i) {
        if(amount==0) return 1;
        if(i>=coins.length || amount<0) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int pick = findWays(coins,dp,amount-coins[i],i);
        int skip = findWays(coins,dp,amount,i+1);
        return dp[i][amount]=pick+skip;

    }
}