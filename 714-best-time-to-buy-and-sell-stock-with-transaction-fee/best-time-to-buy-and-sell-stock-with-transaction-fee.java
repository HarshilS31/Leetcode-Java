class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] dp1 = new int[2];
        int[] dp2 = new int[2];
        for(int i=n-1;i>=0;i--) {
            dp1[0]=Math.max(prices[i]-fee+dp2[1],dp2[0]);
            dp1[1]=Math.max(dp2[0]-prices[i],dp2[1]);
            dp2=dp1;
        }
        return dp1[1];
    }
}