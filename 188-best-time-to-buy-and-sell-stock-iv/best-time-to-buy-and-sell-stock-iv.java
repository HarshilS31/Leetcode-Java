class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int i=prices.length-1;i>=0;i--) {
            for(int j=1;j<=k;j++) {
                dp[i][0][j]=Math.max(prices[i]+dp[i+1][1][j-1],dp[i+1][0][j]);
                dp[i][1][j]=Math.max(dp[i+1][0][j]-prices[i],dp[i+1][1][j]);
            }

        }
        return dp[0][1][k];
        
    }
}