class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return findMaxProfit(0,1,prices,dp,fee);    
    }
    public int  findMaxProfit(int i,int canBuy,int[] prices,int[][] dp,int fee) {
        if(i==prices.length) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        if(canBuy==1) {
            int buy = findMaxProfit(i+1,0,prices,dp,fee)-prices[i];
            int dontBuy = findMaxProfit(i+1,1,prices,dp,fee);
            dp[i][canBuy]=Math.max(buy,dontBuy);

        }
        else {
            int sell = prices[i]-fee + findMaxProfit(i+1,1,prices,dp,fee);
            int dontSell = findMaxProfit(i+1,0,prices,dp,fee);
            dp[i][canBuy]=Math.max(sell,dontSell);
        }
        return dp[i][canBuy];
    }
}