class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp1 = new int[2][3];
        int[][] dp2 = new int[2][3];
        for(int i=prices.length-1;i>=0;i--) {
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++) {
                    if(j==1) {
                        int buy = dp2[0][k]-prices[i];
                        int dontBuy=dp2[1][k];
                        dp1[j][k]=Math.max(buy,dontBuy);
                    }
                    else {
                        int sell = prices[i]+dp2[1][k-1];
                        int dontSell = dp2[0][k];
                        dp1[j][k]=Math.max(sell,dontSell);
                    }
                }
            }
            dp2=dp1;
        }
        return dp1[1][2];
    }
}