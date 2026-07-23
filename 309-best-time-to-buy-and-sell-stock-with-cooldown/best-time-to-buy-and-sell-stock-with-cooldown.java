class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] arr :dp) Arrays.fill(arr,-1);
        return findMaxProfit(0,1,prices,dp);
    }
    public int findMaxProfit(int i,int canBuy,int[] prices,int[][] dp) {
        if(i>=prices.length) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        if(canBuy==1) {
            int buy = findMaxProfit(i+1,0,prices,dp)-prices[i];
            int dontBuy = findMaxProfit(i+1,1,prices,dp);
            dp[i][canBuy]= Math.max(buy,dontBuy);
        }
        else {
            int sell = prices[i]+findMaxProfit(i+2,1,prices,dp);
            int dontSell = findMaxProfit(i+1,0,prices,dp);
            dp[i][canBuy]=Math.max(sell,dontSell);

        }
        return dp[i][canBuy];
    }
}