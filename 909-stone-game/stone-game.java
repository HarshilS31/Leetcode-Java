class Solution {
    public boolean stoneGame(int[] piles) {
        int n =piles.length;
        int[][] dp = new int[n][n];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return whoWins(0,n-1,piles,dp)>0;
    }
    public int whoWins(int i,int j,int[] piles,int[][] dp) {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int pickFirst = piles[i]-whoWins(i+1,j,piles,dp);
        int pickLast = piles[j]-whoWins(i,j-1,piles,dp);
        return dp[i][j]=Math.max(pickFirst,pickLast);

    }
}