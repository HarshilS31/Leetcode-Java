class Solution {
    public boolean stoneGame(int[] piles) {
        int n =piles.length;
        int[][] dp = new int[n][n];
        for(int[] arr :dp) Arrays.fill(arr,-1);
        return diff(piles,dp,0,n-1)>0;
    }
    public int diff(int[] piles,int[][] dp,int i,int j) {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int pickFirst = piles[i]-diff(piles,dp,i+1,j);
        int pickLast = piles[j]-diff(piles,dp,i,j-1);
        return dp[i][j]=Math.max(pickFirst,pickLast);
    }
}