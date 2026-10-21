class Solution {
    final int MAX = 1_000_000_000;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int res = findMin(coins,amount,0,dp); 
        return res  == MAX ? -1 : res;
    }
    public int findMin(int[] coins,int amount,int i,int[][] dp) {
        if(amount==0) return 0;
        if(amount<0 || i==coins.length) return MAX;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int skip = findMin(coins,amount,i+1,dp);
        if(amount<coins[i]) return dp[i][amount]=skip;
        int pick = 1+findMin(coins,amount-coins[i],i,dp);
        return dp[i][amount]=Math.min(pick,skip);
    }
}