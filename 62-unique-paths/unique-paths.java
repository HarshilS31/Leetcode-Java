class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        int[][] dp = new int[m][n];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return paths(m-1,n-1,m,n,dp);
    }
    public int paths(int r,int c,int m ,int n,int[][] dp) {
        if(r==0 || c==0) return 1;
        if(r<0 || c<0) return 0;
        if(dp[r][c]!=-1) return dp[r][c];
        return dp[r][c]=paths(r-1,c,m,n,dp)+paths(r,c-1,m,n,dp);




    }
}