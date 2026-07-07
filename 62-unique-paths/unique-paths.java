class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        int[][] memo = new int[m][n];
        for(int[] arr:memo) Arrays.fill(arr,-1);
        findPaths(memo,m-1,n-1,m,n);
        return memo[m-1][n-1];
    }
    public int findPaths(int[][] memo,int i,int j,int m,int n) {
        if(i>=m || j>=n ) return 0;
        if(i==0 || j==0 ) return 1;
        if(memo[i][j]!=-1) return memo[i][j];
        return memo[i][j]=findPaths(memo,i-1,j,m,n)+findPaths(memo,i,j-1,m,n);
    }

}