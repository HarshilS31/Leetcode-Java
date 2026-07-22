class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp0=0;
        int dp1=0;
        for(int i=n-1;i>=0;i--) {
            dp1=Math.max(dp0-prices[i],dp1);
            dp0=Math.max(prices[i]+dp1,dp0);
        }
        return dp1;
    }   

}