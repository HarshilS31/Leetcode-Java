class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp1 = new int[2][k+1];
        int[][] dp2 = new int[2][k+1];
        for(int i=prices.length-1;i>=0;i--) {
            for(int j=1;j<=k;j++) {
                dp1[0][j]=Math.max(prices[i]+dp2[1][j-1],dp2[0][j]);
                dp1[1][j]=Math.max(dp2[0][j]-prices[i],dp2[1][j]);
            }
            dp2=dp1;
        }
        return dp1[1][k];
        
    }
}