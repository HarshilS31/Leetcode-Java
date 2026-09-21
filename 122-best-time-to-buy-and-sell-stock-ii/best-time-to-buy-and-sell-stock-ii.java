class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return findMaxProfit(prices,dp,0,1);        
    }
    public int findMaxProfit(int[] prices,int[][] dp,int i,int canBuy) {
        if(i==prices.length) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        if(canBuy==1) {
            int buy = findMaxProfit(prices,dp,i+1,0) - prices[i];
            int dontBuy = findMaxProfit(prices,dp,i+1,1);
            return dp[i][canBuy] = Math.max(buy,dontBuy);
        }
        int sell = prices[i]+findMaxProfit(prices,dp,i+1,1);
        int dontSell = findMaxProfit(prices,dp,i+1,0);
        return dp[i][canBuy] = Math.max(sell,dontSell);
    }
}