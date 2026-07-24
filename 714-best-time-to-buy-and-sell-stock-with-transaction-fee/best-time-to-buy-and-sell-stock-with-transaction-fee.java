class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=n-1;i>=0;i--) {
            dp[i][0]=Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
            dp[i][1]=Math.max(dp[i+1][0]-prices[i],dp[i+1][1]);
        }
        return dp[0][1];
    }
}