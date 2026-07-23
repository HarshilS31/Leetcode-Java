class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] matrix:dp) {
            for(int[] row :matrix)  Arrays.fill(row,-1);
        }
        return findProfit(0,1,2,prices,dp);
    }
    public int findProfit(int i,int canBuy,int limit,int[] prices,int[][][] dp) {
        if(i==prices.length || limit==0) return 0;
        if(dp[i][canBuy][limit]!=-1) return dp[i][canBuy][limit];
        if(canBuy==1) {
            int buy = findProfit(i+1,0,limit,prices,dp)-prices[i];
            int dontBuy = findProfit(i+1,1,limit,prices,dp);
            dp[i][canBuy][limit]=Math.max(buy,dontBuy);
        }
        else {
            int sell = prices[i]+findProfit(i+1,1,limit-1,prices,dp);
            int dontSell = findProfit(i+1,0,limit,prices,dp);
            dp[i][canBuy][limit]=Math.max(sell,dontSell);
        }
        return dp[i][canBuy][limit];
    }
}