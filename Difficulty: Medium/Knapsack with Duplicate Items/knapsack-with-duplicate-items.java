class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity+1];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return maxProfit(val,wt,capacity,dp,0);
    }
    public int maxProfit(int[] val,int[] wt,int capacity,int[][]dp,int i) {
        if(i>=val.length || capacity <=0) return 0;
        if(dp[i][capacity]!=-1) return dp[i][capacity];
        if(capacity>=wt[i]) {
            int pick = val[i]+maxProfit(val,wt,capacity-wt[i],dp,i);
            int skip = maxProfit(val,wt,capacity,dp,i+1);
            dp[i][capacity]=Math.max(pick,skip);
        }
        else return dp[i][capacity]=maxProfit(val,wt,capacity,dp,i+1);
        return dp[i][capacity];

    }
}