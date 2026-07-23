class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++) dp[prices.length][i][j]=0;
        }
        for(int i=0;i<=prices.length;i++) {
            for(int j=0;j<2;j++) {
                dp[i][j][0]=0;
            }
        }
        for(int i=prices.length-1;i>=0;i--) {
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++) {
                    if(j==1) {
                        int buy = dp[i+1][0][k]-prices[i];
                        int dontBuy=dp[i+1][1][k];
                        dp[i][j][k]=Math.max(buy,dontBuy);
                    
                    }
                    else {
                        int sell = prices[i]+dp[i+1][1][k-1];
                        int dontSell = dp[i+1][0][k];
                        dp[i][j][k]=Math.max(sell,dontSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}